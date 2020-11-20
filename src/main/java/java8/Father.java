package java8;

final class Father {
    private final String _serviceKey;
    private final String _subEnv;

    Father(String serviceKey,String subEnv){
        _serviceKey=serviceKey;
        _subEnv=subEnv;
    }

    public String get_serviceKey() {
        return _serviceKey;
    }

    public String get_subEnv() {
        return _subEnv;
    }
}
