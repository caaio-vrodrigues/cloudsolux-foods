package com.cloudsolux.foods.global_services.domain.id_control.util;

import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;

public class IdControlMsgCreator {
  
  private IdControlMsgCreator() {}

  public static String unrelatedKeysMsg(IdControlKey currentKey, IdControlKey incomingKey) {
    return "Falha ao processar 'IdControl'. Valores divergentes para as chaves fornecidas: ['chave-atual="+currentKey+"', 'chave-recebida="+incomingKey+"'].";
  }
}