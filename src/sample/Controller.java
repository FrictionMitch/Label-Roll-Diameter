package sample;

//import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
//import javafx.scene.media.Media;

//import java.io.File;


public class Controller{
    @FXML
    private TextField sizeTextField ;
    @FXML
    private TextField qtyTextField;
    @FXML
    private TextField thicknessTextField;
    @FXML
    private TextField diameterTextField;
    @FXML
    private ChoiceBox<String> stockChoiceBox;
    @FXML
    private ChoiceBox<String> lamChoiceBox;
    @FXML
    private TextField coreTextField;
    @FXML
    private TextField rollEventTextField;
    @FXML
    private TextField diameterEventTextField;
    @FXML
    private ImageView kermitImageView;
    @FXML
    private ImageView changImageView;
    @FXML
    private ImageView jeffImageView;
    @FXML
    private ImageView lookImageView;
    @FXML
    private TextField minCoreTextField;
    @FXML
    private TextField runTimeTextField;
    @FXML
    private TextField materialTotalTextField;
    @FXML
    private TextField orderQtyTextField;

    private final AudioClip mHuge = new AudioClip(this.getClass().getResource("/sounds/hugebitch.mp3").toExternalForm());
    private final AudioClip mYeah = new AudioClip(this.getClass().getResource("/sounds/ohYeah.mp3").toExternalForm());
    private final AudioClip mShoot = new AudioClip(this.getClass().getResource("/sounds/shoot.mp3").toExternalForm());
    private final AudioClip mBoom = new AudioClip(this.getClass().getResource("/sounds/boom.mp3").toExternalForm());
    private final AudioClip mFavorite = new AudioClip(this.getClass().getResource("/sounds/favorite.mp3").toExternalForm());
    private final AudioClip mLet = new AudioClip(this.getClass().getResource("/sounds/letmedoit.mp3").toExternalForm());
    private final AudioClip mSecrets = new AudioClip(this.getClass().getResource("/sounds/secrets.mp3").toExternalForm());
    private final AudioClip mTricks = new AudioClip(this.getClass().getResource("/sounds/tricks.mp3").toExternalForm());

//    private AudioClip mHuge = new AudioClip("/sounds/hugebitch.mp3");
//    String path = "/sounds/hugebitch.mpe";
//    AudioClip mHuge = new AudioClip(new File(path).toURI().toString());
//    mediaPlayer = new MediaPlayer(media);
//    mediaPlayer.setAutoPlay(true);


    private double lam = 0;
    private double stockWidth = 0;
    private double offset = 0;
    private double mSize = 0;
    private double mRollQty = 0;
    private int customCount = 0;
    private int imageCount = 0;
    private int randImage = 0;
    private double mMinQty = 0;
    private double mLabelHeight = 0;
    private int mTotalQty = 0;

    public int getTotalQty() {
        return mTotalQty;
    }

    public double getLabelHeight() {
        return Double.parseDouble(sizeTextField.getText());
    }


//    private String mDiameterString = "";

    public double getLam() {
        return lam;
    }
    String stock = "";

    public double getStockWidth() {
        return stockWidth;
    }

    public void clear() {
        sizeTextField.setText("0");
        qtyTextField.setText("0");
        thicknessTextField.setText("0");
        diameterTextField.setText("0");
        coreTextField.setText("0");
        rollEventTextField.setText("0.00");
        diameterEventTextField.setText("0.00");
        lamChoiceBox.getSelectionModel().selectFirst();
        stockChoiceBox.setVisible(true);
        stockChoiceBox.getSelectionModel().selectFirst();
        thicknessTextField.setVisible(false);
        coreTextField.setEditable(false);
        coreTextField.setText("3.25");
        coreTextField.setFocusTraversable(false);
        kermitImageView.setVisible(false);
        changImageView.setVisible(false);
        jeffImageView.setVisible(false);
        lookImageView.setVisible(false);
        customCount = 0;
        imageCount = 0;
        mMinQty = 0;
        minCoreTextField.setText(String.valueOf(mMinQty));
        runTimeTextField.setText("0.00");
        materialTotalTextField.setText("0.00");
        orderQtyTextField.setText("0.00");
    }

    public void customImageCount() {
        kermitImageView.setVisible(false);
        changImageView.setVisible(false);
        jeffImageView.setVisible(false);
        lookImageView.setVisible(false);
        imageCount += 1;
        randImage = (int)(Math.random() * 50);
        if (imageCount > 4) {

            switch (randImage) {
                case 5:
                    kermitImageView.setVisible(true);
                    imageCount += 1;
                    mYeah.play();
                    break;
                case 7:
                    changImageView.setVisible(true);
                    imageCount += 1;
                    mYeah.play();
                    break;
                case 10:
                    jeffImageView.setVisible(true);
                    imageCount += 1;
                    mBoom.play();
                    break;
                case 20:
                    lookImageView.setVisible(true);
                    imageCount += 1;
                    mLet.play();
                    break;

                default:
                    kermitImageView.setVisible(false);
                    changImageView.setVisible(false);
                    jeffImageView.setVisible(false);
                    lookImageView.setVisible(false);

            }
        }

    }

    public void laminate() {
        String type = lamChoiceBox.getValue();
        switch (type) {
            case "NONE":
                lam = 0;
                break;
            case "Clear/Matte":
                lam = 1.5;
                break;
            case "White":
                lam = 4;
                break;
            default:
                lam = 0;
                break;
        }
    }

    public void substrate() {
        stock = stockChoiceBox.getValue();
        if (thicknessTextField.isVisible()) {
            stockWidth = Double.parseDouble(thicknessTextField.getText());
        } else {
        switch (stock) {
            case "Bopp":
                if (Double.parseDouble(sizeTextField.getText()) > 5) {
                    stockWidth = 7;
                } else {
                    stockWidth = 6.5;
                }
                break;

            case "Bopp Removable":
                if (Double.parseDouble(sizeTextField.getText()) > 5) {
                    stockWidth = 6.5;
                } else {
                    stockWidth = 6;
                }
                break;

            case "Matte":
                if (Double.parseDouble(sizeTextField.getText()) < 1.5) {
                    stockWidth = 5.75;
                }
                if (Double.parseDouble(sizeTextField.getText())>= 1.5 &&
                    Double.parseDouble(sizeTextField.getText()) < 5) {
                stockWidth = 6.25;
            }
                if (Double.parseDouble(sizeTextField.getText()) >= 5) {
                    stockWidth = 6.5;
                }
                break;

            case "Silver":
                stockWidth = 6.5;
                break;

            case "SemiGloss":
                if (Double.parseDouble(sizeTextField.getText()) < 2) {
                    stockWidth = 5.5;
                } else {
                    stockWidth = 6;
                }
                break;

            case "PET":
                stockWidth = 6.55;
                break;
            case "Blockout":
                stockWidth = 6.7;
                break;

            case "Fluorescent":
                if (Double.parseDouble(sizeTextField.getText()) > 5) {
                    stockWidth = 7.2;
                } else {
                    stockWidth = 6.5;
                }
                break;

            case "SuperTac":
                if (Double.parseDouble(sizeTextField.getText()) > 3) {
                    stockWidth = 7;
                } else {
                    stockWidth = 6.5;
                }
                break;

            default:
                stockWidth = 6.5;
                break;
        }
        }
    }


//    stockChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<stock>() {
//
//    });
    public void handleCustom(ActionEvent actionEvent) {
            customCount += 1;
            if (customCount % 2 != 0) {
                stockChoiceBox.setVisible(false);
                thicknessTextField.setVisible(true);
                thicknessTextField.isFocusTraversable();
//            diameterTextField.setVisible(false);
                stockWidth = Double.parseDouble(thicknessTextField.getText());
                coreTextField.setEditable(true);
                coreTextField.setFocusTraversable(true);
            } else {
                stockChoiceBox.setVisible(true);
                thicknessTextField.setVisible(false);
                thicknessTextField.setFocusTraversable(false);
//                stockWidth = Double.parseDouble(stockChoiceBox.getValue());
                coreTextField.setEditable(false);
                coreTextField.setFocusTraversable(false);
            }
    }

    public void offsetWidth(double diameter, double gap) {
        offset = diameter - (gap/(diameter-gap));
    }

//    public void extra () {
//        String name = "";
//        switch (name) {
//            case ".101":
//                kermitImageView.setVisible(true);
//                mYeah.play();
//                break;
//            case ".102":
//                changImageView.setVisible(true);
//                mShoot.play();
//                break;
//            case ".103":
//                jeffImageView.setVisible(true);
//                break;
//            default:
//                kermitImageView.setVisible(false);
//                changImageView.setVisible(false);
//                jeffImageView.setVisible(false);
//                break;
//        }
//    }

    public void handleDiameter(ActionEvent actionEvent) {
//        mHuge = new AudioClip(getClass().getResource("/sounds/hugeBitch.mp3").toExternalForm());
            kermitImageView.setVisible(false);
            changImageView.setVisible(false);
            jeffImageView.setVisible(false);
            mLabelHeight = Double.parseDouble(sizeTextField.getText());
            laminate();
            substrate();
            Equation equation = new Equation(
            Double.parseDouble(sizeTextField.getText()),
            Double.parseDouble(qtyTextField.getText()),
//            Double.parseDouble(thicknessTextField.getText()) + getLam(),
            getStockWidth() + getLam(),
            Double.parseDouble(coreTextField.getText()));
            equation.diameter();
//            if (Double.parseDouble(thicknessTextField.getText()) + getLam() < 7 &&
//                    Double.parseDouble(sizeTextField.getText()) < 2.5) {
//                offsetWidth(equation.getDiameter(), equation.GAP);
//                diameterEventTextField.setText(Double.toString(offset));
//            } else {
                mSize = equation.getDiameter();
                String mDiameterString = String.format("%.4f", mSize);
            if (Double.parseDouble(sizeTextField.getText()) < 0.01) {
                diameterEventTextField.setText("0");
            } else {
                diameterEventTextField.setText(mDiameterString);
//                diameterEventTextField.setText(Double.toString(mSize));
                if (Double.parseDouble(diameterEventTextField.getText()) > 8) {
                    mHuge.play();
                }
                double imageLength = Double.parseDouble(sizeTextField.getText()) + equation.GAP;
                mMinQty = equation.MIN_CORE / imageLength;
                Integer core = (int) mMinQty;
                minCoreTextField.setText(String.valueOf(core));
//                if (Double.parseDouble(materialTotalTextField.getText()) < 0.01) {
//
//                }
                double materialTotal = ((equation.getHeight()+equation.GAP)*
                        Integer.parseInt(orderQtyTextField.getText())/12);
                materialTotalTextField.setText(String.format("%.2f", materialTotal));
                double totMat = Double.parseDouble(materialTotalTextField.getText());
//                String coreString = qtyTextField.getText();
//                String totalString = orderQtyTextField.getText();
//                double cores = (Double.parseDouble(totalString))/
//                        (Double.parseDouble(coreString));
//                double coreQty = cores * equation.MINUTES;
                runTimeTextField.setText(String.format("%.1f", ((totMat)/equation.getSpeed())));
//                runTimeTextField.setText(String.valueOf((1250/12)/equation.getSpeed()));
            }

        if (sizeTextField.getText().endsWith(".101")) {
            kermitImageView.setVisible(true);
            imageCount += 1;
                mYeah.play();
        }
        if (sizeTextField.getText().endsWith(".102")) {
            changImageView.setVisible(true);
            imageCount += 1;
                mShoot.play();
        }
        if (sizeTextField.getText().endsWith(".103")) {
            jeffImageView.setVisible(true);
            imageCount += 1;
                mBoom.play();
        }
        if (sizeTextField.getText().equalsIgnoreCase("69")) {
            lookImageView.setVisible(true);
            Integer songCount;
            imageCount += 1;

            songCount = (int)(Math.random() * 8);

                switch (songCount) {
                    case 1:
                        mFavorite.play();
                        break;
                    case 2:
                        mLet.play();
                        break;
                    case 3:
                        mSecrets.play();
                        break;
                    case 4:
                        mTricks.play();
                        break;
                    case 5:
                        mLet.play();
                        break;
                    case 6:
                        mTricks.play();
                        break;
                    case 7:
                        mTricks.play();
                        break;
                    case 8:
                        mLet.play();
                        break;
                    default:
                        mLet.play();
                        break;
            }
        }
        if (sizeTextField.getText().endsWith(".104")) {
            lookImageView.setVisible(true);
            imageCount += 1;
            mShoot.play();
        }
    }



    public void handleRollQty(ActionEvent actionEvent) {
            laminate();
            substrate();
            imageCount+=1;
            Equation roll = new Equation(
            Double.parseDouble(sizeTextField.getText()),
            Double.parseDouble(diameterTextField.getText()),
//            Double.parseDouble(thicknessTextField.getText()),
            getStockWidth() + getLam(),
            Double.parseDouble(coreTextField.getText()));
            roll.rollQty();
            mRollQty = roll.getRollQty();
            String rollQtyString = String.format("%.2f", mRollQty);
        if (Double.parseDouble(sizeTextField.getText()) < 0.01 ||
        Double.parseDouble(diameterTextField.getText()) < 0.01) {
            rollEventTextField.setText("0");
        } else {
            rollEventTextField.setText(rollQtyString);
//        rollEventTextField.setText(Double.toString(roll.getRollQty()));
        }
            customImageCount();
    }

    public void handleClear(ActionEvent actionEvent) {

        clear();
    }
}
