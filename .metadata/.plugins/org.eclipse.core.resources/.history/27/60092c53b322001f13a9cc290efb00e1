package co.edu.uco.deviucopay.crosscutting.helpers;

public final class FloatHelper {
    
    public static final Float ZERO = 0.0f;
    
    private FloatHelper() {
        super();
    }
    
    public static final boolean isNull(final Float value) {
        return ObjectHelper.getObjectHelper().isNull(value);
    }
    
    public static final Float getDefaultValue(final Float value, final Float defaultValue) {
        return ObjectHelper.getObjectHelper().getDefaultValue(value, defaultValue);
    }
    
    public static final Float getDefaultValue(final Float value) {
        return getDefaultValue(value, ZERO);
    }
    
    public static final boolean isEqual(final Float firstValue, final Float secondValue) {
        return getDefaultValue(firstValue).equals(getDefaultValue(secondValue));
    }
    
    public static final boolean isGreaterThan(final Float firstValue, final Float secondValue) {
        return getDefaultValue(firstValue) > getDefaultValue(secondValue);
    }
    
    public static final boolean isLessThan(final Float firstValue, final Float secondValue) {
        return getDefaultValue(firstValue) < getDefaultValue(secondValue);
    }
}
