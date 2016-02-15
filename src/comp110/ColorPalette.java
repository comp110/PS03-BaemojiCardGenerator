package comp110;

/**
 * This is support code. You do not need to change it. Feel free to tinker with
 * it, though.
 */
class ColorPalette {

  Color _background;
  Color _fontColor;
  Color _petalColor;
  Color _discColor;
  Color _stemColor;
  Color _white;

  ColorPalette() {
    _white = new Color();

    _background = _white;

    _fontColor = new Color(0.18, 0.18, 0.31);

    _petalColor = new Color(0.48, 0.69, 0.83);
    _discColor = _fontColor;
    _stemColor = new Color(0.36, 0.61, 0.39);
  }

  Color getWhite() {
    return _white;
  }

  Color getBackground() {
    return _background;
  }

  Color getFontColor() {
    return _fontColor;
  }

  Color getPetalColor() {
    return _petalColor;
  }

  Color getDiscColor() {
    return _discColor;
  }

  Color getStemColor() {
    return _stemColor;
  }

}
