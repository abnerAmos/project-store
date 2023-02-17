package com.project.store.enums;

public enum OrderStatus {

    /* Caso a model que instancie o enum não esteja com a annotation @Enumerated,
    o banco de dados irá adora o valor do array dos  enums, isso pode gerar conflitos posteriores caso seja adicionado mais enums.

    É possivel gerar código numerados aos Enums ao invés do valor,
    para isso é necessário montar um atributo privado, construtor e um getter,
    em seguida um método Static que faça um for e percorra todos os numeros. */
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
