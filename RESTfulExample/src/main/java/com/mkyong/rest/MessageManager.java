package com.mkyong.rest;

import java.util.HashMap;
import java.util.Map;

public class MessageManager {
	private static MessageManager instance = null;
	
	public static MessageManager getInstance() {
		if(instance == null)
			instance = new MessageManager();
		return instance;
	}
	
	private HashMap<String, HashMap<String, String>> dictionnaires;
	
	private MessageManager() {
		dictionnaires = new HashMap<String, HashMap<String, String>>();
		// initialisation par défaut
		HashMap<String, String> fr = new HashMap<String, String>();
		fr.put("msg1", "Bonjour");
		fr.put("msg2", "Au revoir");
		dictionnaires.put("fr", fr);
		
		HashMap<String, String> en = new HashMap<String, String>();
		en.put("msg1", "Hello");
		en.put("msg2", "Good Bye");
		dictionnaires.put("en", en);
	}
	
	public Map<String, String> getMessages(String langIsoCode) {
		if(!dictionnaires.containsKey(langIsoCode))
			dictionnaires.put(langIsoCode, new HashMap<String, String>());
		return dictionnaires.get(langIsoCode);
	}
	
	public String getMessage(String langIsoCode, String key) {
		if(dictionnaires.containsKey(langIsoCode)) {
			HashMap<String, String> dico = dictionnaires.get(langIsoCode);
			if(dico.containsKey(key))
				return dico.get(key);
		}
		return langIsoCode+ "_" + key;
	}
	
	public void addMessage(String langIsoCode, String key, String value) {
		if(!dictionnaires.containsKey(langIsoCode))
			dictionnaires.put(langIsoCode, new HashMap<String, String>());
		HashMap<String, String> dico = dictionnaires.get(langIsoCode);
		if(!dico.containsKey(key))
			dico.put(key, value);
	}
	
	public void removeMessage(String langIsoCode, String key, String value) {
		if(dictionnaires.containsKey(langIsoCode)) {
			HashMap<String, String> dico = dictionnaires.get(langIsoCode);
			dico.remove(key);
		}
	}
}
