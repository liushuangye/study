package com.study.demo.annotation.enums;

public enum SexEnum {
    MALE("MALE","男"),
    FEMALE("FEMALE","女")
    ;

    private final String codeId;
    private final String codeName;
    private SexEnum(final String codeId, final String codeName){
        this.codeId = codeId;
        this.codeName = codeName;
    }
    public static String getCodeId(String codeName) {
        SexEnum[] sexEnums = values();
        for (SexEnum sexEnum : sexEnums) {
            if (sexEnum.codeName().equals(codeName)) {
                return sexEnum.codeId();
            }
        }
        return null;
    }
    public static String getCodeName(String codeId) {
        SexEnum[] sexEnums = values();
        for (SexEnum sexEnum : sexEnums) {
            if (sexEnum.codeId().equals(codeId)) {
                return sexEnum.codeName();
            }
        }
        return "";
    }

    public String codeId(){
        return this.codeId;
    }

    public String codeName(){
        return this.codeName;
    }
    }
