package com.italankin.fifteen;

public class Dimensions {

    /**
     * ширина области рисования
     */
    public static float surfaceWidth;
    /**
     * высота области рисования
     */
    public static float surfaceHeight;
    /**
     * размер стороны плитки
     */
    public static float tileSize;
    /**
     * радиус закругления углов спрайтов
     */
    public static float tileCornerRadius;
    /**
     * ширина поля (на области рисования)
     */
    public static float fieldWidth;
    /**
     * высота поля (на области рисования)
     */
    public static float fieldHeight;
    /**
     * отступ поля от левого края
     */
    public static float fieldMarginLeft;
    /**
     * отступ поля от верхнего края
     */
    public static float fieldMarginTop;
    /**
     * размер шрифта на спрайтах
     */
    public static float tileFontSize;
    /**
     * размер шрифта элементов интерфейса
     */
    public static float interfaceFontSize;
    /**
     * размер шрифта меню
     */
    public static float menuFontSize;
    /**
     * отступ между ячейками на поле
     */
    public static float spacing;

    /**
     * Рассчитывает размеры элементов относительно текущих настроек игры
     *
     * @param width  ширина области рисования
     * @param height высота области рисования
     * @param scale  коэффициент масштабирования
     */
    public static void update(int width, int height, float scale) {
        surfaceWidth = width * scale;
        surfaceHeight = height * scale;

        spacing = Math.min(surfaceWidth, surfaceHeight) * 0.015f;
        fieldMarginTop = 0.32f * surfaceHeight;

        int sideMax = Math.max(Settings.gameWidth, Settings.gameHeight);
        float spriteSize = Math.min(surfaceWidth, surfaceHeight - fieldMarginTop)
                - spacing * (sideMax + 1);

        tileSize = spriteSize / sideMax;

        fieldWidth = (tileSize + spacing) * Settings.gameWidth - spacing;
        fieldHeight = (tileSize + spacing) * Settings.gameHeight - spacing;
        tileFontSize = Math.max(tileSize / 2.45F, 4.5f);
        interfaceFontSize = Math.max(Math.round(surfaceHeight * 0.029), 11.0f);
        menuFontSize = interfaceFontSize * 1.5f;
        fieldMarginLeft = 0.5f * surfaceWidth - 0.5f * fieldWidth;
        tileCornerRadius = 0.0f;
    }

}