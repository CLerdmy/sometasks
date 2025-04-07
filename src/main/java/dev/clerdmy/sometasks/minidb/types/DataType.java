package dev.clerdmy.sometasks.minidb.types;

public enum DataType {

    INTEGER {
        public Object parse(String value) {
            return Integer.parseInt(value);
        }
    },
    DOUBLE {
        public Object parse(String value) {
            return Double.parseDouble(value);
        }
    },
    STRING {
        public Object parse(String value) {
            return value;
        }
    },
    BOOLEAN {
        public Object parse(String value) {
            return Boolean.parseBoolean(value);
        }
    };

    public abstract Object parse(String value);

}
