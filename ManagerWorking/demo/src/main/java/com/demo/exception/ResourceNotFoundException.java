package com.demo.exception;

/*********************************************************************
 *
 * ClassName: ResourceNotFoundException 
 * Implementation of the Class: Handel of ResourceNotFoundException 
 * Created on: 2022-06-07
 * 
 * @author: HieuNT
 *
 *********************************************************************/
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * resource Name
     */
    private String resourceName;

    /**
     * field Name
     */
    private String fieldName;

    /**
     * field Value
     */
    private Object fieldValue;

    /**
     * Handel of ResourceNotFoundException
     * 
     * @param resourceName: resource Name
     * @param fieldName:    fieldName
     * @param fieldValue:   field Value
     * @return ResourceNotFoundException
     */
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

}
