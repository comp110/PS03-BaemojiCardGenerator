package comp110;

/**
 * You will be making changes to this skeleton code in Part D.
 */
class Card {

  /* Instance Variables */
  ColorPalette _colors;

  /* Constructor */
  Card() {
    _colors = new ColorPalette();
  }

  /* Methods */
  Shapes getShapes() {
    Shapes container = new Shapes();
    container.add(this.makeBackground());

    String bigMessage = "COMP110 Loves You!";
    Text messageBox = this.makeText(bigMessage, 40, 512, true);
    messageBox.setStroke(_colors.getPetalColor());
    messageBox.setStrokeWidth(1);
    messageBox.setCentered(true);
    messageBox.setTranslateX(0);
    messageBox.setTranslateY(40);
    container.add(messageBox);

    String smallMessage = "<3 Kris & The COMP110 Team";
    Text affectionBox = this.makeText(smallMessage, 18, 300, false);
    affectionBox.setTranslateX(220);
    affectionBox.setTranslateY(80);
    affectionBox.setCentered(false);
    container.add(affectionBox);

    container.add(this.makeFlowers());
    return container;
  }

  /* Helper Methods for Drawing Shapes */
  Rectangle makeBackground() {
    Rectangle background = new Rectangle();
    background.setWidth(512);
    background.setHeight(512);
    background.setFill(_colors.getBackground());
    return background;
  }

  Flower makeFlower(int petals, double petalLength, double petalThickness,
      double discRadius) {
    Flower flower = new Flower();
    flower.setDiscColor(_colors.getDiscColor());
    flower.setPetalColor(_colors.getPetalColor());
    flower.setStemColor(_colors.getStemColor());
    flower.setPetalCount(petals);
    flower.setPetalLength(petalLength);
    flower.setDiscRadius(discRadius);
    flower.setPetalThickness(petalThickness);
    return flower;
  }

  Text makeText(String caption, double fontSize, double width, boolean bold) {
    Font font = new Font("Consolas", bold, fontSize);
    Text message = new Text(caption);
    message.setWrappingWidth(width);
    message.setFont(font);
    message.setFill(_colors.getFontColor());
    return message;
  }

  Shapes makeFlowers() {
    Shapes container = new Shapes();

    Flower leftFlower = this.makeFlower(12, 32.0, 10.0, 12.0);
    leftFlower.setScale(1.75);
    leftFlower.setTranslateY(290.0);
    leftFlower.setTranslateX(130.0);
    container.add(leftFlower);

    Flower rightFlower = this.makeFlower(12, 32.0, 10.0, 12.0);
    rightFlower.setScale(1.75);
    rightFlower.setTranslateY(290.0);
    rightFlower.setTranslateX(370.0);
    container.add(rightFlower);

    Flower centerFlower = this.makeFlower(64, 48.0, 6.0, 24.0);
    centerFlower.setScale(2.0);
    centerFlower.setTranslateY(280.0);
    centerFlower.setTranslateX(256.0);
    centerFlower.setStemLength(128.0);
    container.add(centerFlower);

    return container;
  }

}