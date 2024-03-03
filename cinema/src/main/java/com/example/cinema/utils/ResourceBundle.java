package com.example.cinema.utils;

import java.util.Locale;

public class ResourceBundle {
    private ResourceBundle(){}

    private static final java.util.ResourceBundle messagesRu =
            java.util.ResourceBundle.getBundle("message_ru",
                    Locale.forLanguageTag("ru"));

    private static final java.util.ResourceBundle messagesEn =
            java.util.ResourceBundle.getBundle("message_en",
                    Locale.forLanguageTag("en"));

    public static String periodMessages(String key, Language language) {
        switch (language){
            case EN :
                return messagesEn.getString(key);
            case RU :
            default:
                return messagesRu.getString(key);
            }
        }
        }


