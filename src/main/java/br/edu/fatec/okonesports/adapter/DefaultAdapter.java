package br.edu.fatec.okonesports.adapter;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.okonesports.adapter.annotations.AdapterRestrictions;
import br.edu.fatec.okonesports.exception.AdapterException;

public abstract class DefaultAdapter<T> {

	@SuppressWarnings("unchecked")
	public T adapt() throws Exception {
		T obj = (T) getObjectParametrizedType(this).newInstance();
		for (Field objField : obj.getClass().getDeclaredFields()) {
			objField.setAccessible(true);
			Field thisField = null;
			try {
				String nameRestriction = getNameRestriction(objField);
				thisField = this.getClass().getDeclaredField(
						nameRestriction == null ? objField.getName()
								: nameRestriction);
				thisField.setAccessible(true);
				if (objField.getType().equals(List.class)
						&& thisField.getType().equals(List.class)) {
					adaptListValue(objField, thisField, obj);
				} else {
					adaptValue(obj, objField, thisField);
				}
			} catch (NoSuchFieldException e) {
				continue;
			} catch (ClassCastException e) {
				throw new AdapterException("Erro de cast\nTipos: ["
						+ objField.getType().getSimpleName() + " e "
						+ thisField.getType().getSimpleName()
						+ "]\nAtributos: [" + objField.getName() + " e "
						+ thisField.getName() + "]\nClasse: ["
						+ this.getClass().getSimpleName() + "]");
			}
		}
		return obj;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void adaptListValue(Field objField, Field thisField, Object obj)
			throws IllegalAccessException, Exception {
		List objList = (List) objField.get(obj);
		if (objList == null) {
			objList = new ArrayList();
		}
		Class<?> thisClassField = getGenericListParameterizedType(thisField);
		Class<?> objClassField = getGenericListParameterizedType(objField);
		if (thisClassField.getSuperclass().equals(DefaultAdapter.class)) {
			for (Object thisListField : (List) thisField.get(this)) {
				objList.add(((DefaultAdapter<?>) thisListField).adapt());
			}
		} else if (thisClassField.equals(objClassField)) {
			objList = (List) thisField.get(this);
		} else {
			for (Object thisListField : (List) thisField.get(this)) {
				objList.add(objClassField.cast(thisListField));
			}
		}
		objField.set(obj, objList);
	}

	private void adaptValue(T obj, Field objField, Field thisField)
			throws IllegalAccessException, Exception {
		if (objField.getType().getSuperclass().equals(DefaultAdapter.class)) {
			objField.set(obj, ((DefaultAdapter<?>) thisField.get(this)).adapt());
		} else {
			objField.set(obj,
					isSameType(objField, thisField) ? thisField.get(this)
							: objField.getType().cast(thisField.get(this)));
		}
	}

	private Class<?> getObjectParametrizedType(Object obj) {
		return ((Class<?>) ((ParameterizedType) obj.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	private Class<?> getGenericListParameterizedType(Field field) {
		return (Class<?>) ((ParameterizedType) field.getGenericType())
				.getActualTypeArguments()[0];
	}

	private String getNameRestriction(Field field) {
		if (field.getAnnotation(AdapterRestrictions.class) != null
				&& !field.getAnnotation(AdapterRestrictions.class)
						.nameRestriction().equals("")) {
			return field.getAnnotation(AdapterRestrictions.class)
					.nameRestriction();
		}
		return null;
	}

	private boolean isSameType(Field firstField, Field secondField) {
		return firstField.getType().equals(secondField.getType());
	}

}