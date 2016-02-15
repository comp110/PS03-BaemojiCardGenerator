package comp110;

/**
 * This is support code provided for educational purposes.
 * 
 * You encouraged to read through this class!
 * 
 * This class uses some Math library methods we have not yet discussed: random,
 * max, min, cos, sin. These methods work mostly how you would expect, but feel
 * free to explore with them if you'd like to use more advanced math methods in
 * your own programs. We'll cover the Math class after midterm.
 */

class Flower extends Drawing {

  /* Instance Variables (Properties) */
  int _petalCount;
  double _petalLength;
  double _discRadius;
  double _petalThickness;
  double _stemLength;
  Color _petalColor;
  Color _discColor;
  Color _stemColor;

  /* Constructor (Initializes Instance Variables) */
  Flower() {
    _petalCount = 9;
    _petalLength = 32.0;
    _discRadius = 16.0;
    _petalThickness = 8.0;
    _stemLength = 96.0;
    _petalColor = new Color(0, 0, 0, 0);
    _discColor = new Color();
    _stemColor = new Color(0.5, 0.5, 0.5);
  }

  /* Construct our flower using some helper methods. */
  Shapes getShapes() {
    Shapes container = new Shapes();
    container.add(this.makeStem());
    container.add(this.makePetals());
    container.add(this.makeDisc());
    return container;
  }

  Path makeStem() {
    Path stem = new Path();

    StartingPoint sp = new StartingPoint();
    sp.setX(0);
    sp.setY(0);
    stem.add(sp);

    CubicCurveTo line = new CubicCurveTo();
    line.setX(0);
    line.setY(_stemLength);
    double segmentLength = _stemLength / 4.0;
    double swayWidth = _stemLength / 4.0;
    double x1 = this.randomNumber(-1.0 * swayWidth, swayWidth);
    line.setControlX1(x1);
    double y1 = this.randomNumber(segmentLength * 1.5, segmentLength * 2.0);
    line.setControlY1(y1);
    double x2 = this.randomNumber(-1.0 * swayWidth, swayWidth);
    line.setControlX2(x2);
    double y2 = this.randomNumber(segmentLength * 3.0, segmentLength * 3.5);
    line.setControlY2(y2);
    stem.add(line);
    stem.setStroke(_stemColor);
    stem.setStrokeWidth(_discRadius / 4.0);

    return stem;
  }

  Shapes makePetals() {
    Shapes petals = new Shapes();
    int count = 0;
    double randomizedStartAngle = this.randomNumber(0.0, 45.0);
    while (count < _petalCount) {
      double angle = 1.0 * count / _petalCount * 360.0;
      petals.add(this.makePetal(angle + randomizedStartAngle));
      count++;
    }
    return petals;
  }

  Shapes makePetal(double angle) {
    Shapes petalContainer = new Shapes();

    Circle petal = new Circle();
    petal.setRadius(_petalLength / 2.0);
    petal.setScaleY(_petalThickness / _petalLength);
    petal.setFill(this.randomColorNear(_petalColor));
    petal.setStrokeWidth(0.0);
    petal.setCenterX(_petalLength);
    petal.setCenterY(0.0);
    petalContainer.add(petal);

    // We'll add +/- 5 degrees randomization to the default
    // to fake nature's own subtle entropy in petal growth.
    double entropy = this.randomNumber(-5.0, 5.0);
    petalContainer.setRotation(angle + entropy);

    /*
     * Now we need to rotate our petal and move it to the edge of the disc. The
     * innermost side of the petal will go beneath the disc some.
     * 
     * Hello precalc, good to see you again.
     */
    double angleInRad = Math.toRadians(angle);
    double flowerRadius = _discRadius + (_petalLength / 2.0) * 0.5;
    double dX = Math.cos(angleInRad) * flowerRadius - _petalLength;
    double dY = Math.sin(angleInRad) * flowerRadius;
    petalContainer.setTranslateX(dX);
    petalContainer.setTranslateY(dY);

    return petalContainer;
  }

  /*
   * Return a circle that represents the center part of the flower.
   */
  Circle makeDisc() {
    Circle disc = new Circle();
    disc.setRadius(_discRadius);
    disc.setCenterX(0.0);
    disc.setCenterY(0.0);
    disc.setFill(_discColor);
    disc.setStrokeWidth(0.0);
    return disc;
  }

  /**
   * Helper Methods
   */

  /*
   * Given a Color, return a new, randomized Color that is within +/- 15% of the
   * original color.
   */
  Color randomColorNear(Color color) {
    double colorEntropy = this.randomNumber(-0.15, 0.15);
    double red = this.boundPercentage(color.getRed() + colorEntropy);
    double green = this.boundPercentage(color.getGreen() + colorEntropy);
    double blue = this.boundPercentage(color.getBlue() + colorEntropy);
    return new Color(red, green, blue);
  }

  /*
   * Given a min and max range, choose a random number between them. This random
   * number will be inclusive of min and exclusive of max.
   */
  double randomNumber(double min, double max) {
    double range = max - min;
    double random = Math.random() * range;
    return min + random;
  }

  /*
   * Given an input that is any double number, return a double that is that
   * number unless it falls outside of the bounds of 0.0 and 1.0. In those
   * cases, constrain the number to 0.0 or 1.0.
   */
  double boundPercentage(double input) {
    return Math.min(Math.max(input, 0.0), 1.0);
  }

  /**
   * Accessor and Mutator Methods
   */
  void setPetalCount(int petalCount) {
    _petalCount = petalCount;
  }

  int getPetalCount() {
    return _petalCount;
  }

  void setPetalLength(double petalLength) {
    _petalLength = petalLength;
  }

  double getPetalLength() {
    return _petalLength;
  }

  void setDiscRadius(double discRadius) {
    _discRadius = discRadius;
  }

  double getDiscRadius() {
    return _discRadius;
  }

  void setPetalThickness(double petalThickness) {
    _petalThickness = petalThickness;
  }

  double getPetalThickness() {
    return _petalThickness;
  }

  void setPetalColor(Color petalColor) {
    _petalColor = petalColor;
  }

  Color getPetalColor() {
    return _petalColor;
  }

  void setDiscColor(Color discColor) {
    _discColor = discColor;
  }

  Color getDiscColor() {
    return _discColor;
  }

  void setStemColor(Color stemColor) {
    _stemColor = stemColor;
  }

  Color getStemColor() {
    return _stemColor;
  }

  void setStemLength(double stemLength) {
    _stemLength = stemLength;
  }

  double getStemLength() {
    return _stemLength;
  }
}
