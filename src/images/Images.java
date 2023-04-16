package images;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Banque de données d'images
 */
public class Images {

    public final Random randomGen = new Random();
    private final ArrayList<Image> toRight = new ArrayList<>();
    private final ArrayList<Image> toLeft = new ArrayList<>();
    private final ArrayList<Image> blueTruckRight = new ArrayList<>();
    private final ArrayList<Image> yellowTruckLeft = new ArrayList<>();
    private final ArrayList<Image> turtleLeft = new ArrayList<>();
    private final ArrayList<Image> logTwoLeft = new ArrayList<>();
    private final ArrayList<Image> logThreeLeft = new ArrayList<>();
    private final ArrayList<Image> turtleRight = new ArrayList<>();
    private final ArrayList<Image> logTwoRight = new ArrayList<>();
    private final ArrayList<Image> logThreeRight = new ArrayList<>();


    public Images(){
        this.toRight.addAll(Arrays.asList(greenCarImageRight, redBikeImageRight, redCarImageRight, whiteCarImageRight));
        this.toLeft.addAll(Arrays.asList(blackCarImageLeft, blueBikeImageLeft, blueCarImageLeft, pinkCarImageLeft));
        this.blueTruckRight.addAll(Arrays.asList(blueTruckImageRight2, blueTruckImageRight1));
        this.yellowTruckLeft.addAll(Arrays.asList(yellowTruckImageLeft1, yellowTruckImageLeft2));

        this.turtleLeft.add(turtleImageLeft);
        this.logTwoLeft.addAll(Arrays.asList(logTwoImageLeft, logTwoImageLeft2));
        this.logThreeLeft.addAll(Arrays.asList(logThreeImageLeft, logThreeImageLeft2, logThreeImageLeft3));
        this.turtleRight.add(turtleImageRight);
        this.logTwoRight.addAll(Arrays.asList(logTwoImageRight, logTwoImageRight2));
        this.logThreeRight.addAll(Arrays.asList(logThreeImageRight, logThreeImageRight2, logThreeImageRight3));
    }

    /**
     * Donne une image selon sa direction sa taille et sa nature
     * @param directionToRight
     * @param length
     * @param isWater
     * @return
     */
    public ArrayList<Image> giveObstacle(boolean directionToRight, int length, boolean isWater){
        ArrayList<Image> res = new ArrayList<>();
        switch(length){
            case 1:
                if(directionToRight && isWater) {
                    res.add(turtleRight.get(0));
                    return res;
                }
                if(directionToRight) {
                    res.add(toRight.get(randomGen.nextInt(toRight.size())));
                    return res;
                }

                if(isWater) {
                    res.add(turtleLeft.get(0));
                    return res;
                }
                res.add(toLeft.get(randomGen.nextInt(toLeft.size())));
                return res;

            case 2:
                if(directionToRight && isWater) {
                    res.addAll(logTwoRight);
                    return res;
                }
                if(directionToRight) {
                    res.addAll(blueTruckRight);
                    return res;
                }

                if(isWater){
                    res.addAll(logTwoLeft);
                }
                res.addAll(yellowTruckLeft);
                return res;

            case 3:
                if(directionToRight && isWater){
                    res.addAll(logThreeRight);
                    return res;
                }
        }

        res.addAll(logThreeLeft);
        return res;
    }


    // Left obstacles
    public static Image blackCarImageLeft;
    static {
        try {
            blackCarImageLeft = ImageIO.read(new File("src/images/road_obstacles/left/black_car_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image blueBikeImageLeft;
    static {
        try {
            blueBikeImageLeft = ImageIO.read(new File("src/images/road_obstacles/left/blue_bike_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image blueCarImageLeft;
    static {
        try {
            blueCarImageLeft = ImageIO.read(new File("src/images/road_obstacles/left/blue_car_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image pinkCarImageLeft;
    static {
        try {
            pinkCarImageLeft = ImageIO.read(new File("src/images/road_obstacles/left/pink_car_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image yellowTruckImageLeft1;
    static {
        try {
            yellowTruckImageLeft1 = ImageIO.read(new File("src/images/road_obstacles/left/yellow_truck_left1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image yellowTruckImageLeft2;
    static {
        try {
            yellowTruckImageLeft2 = ImageIO.read(new File("src/images/road_obstacles/left/yellow_truck_left2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Pieges
    public static Image bombImage;
    static {
        try {
            bombImage = ImageIO.read(new File("src/images/pieges/bomb.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image tremplinImage;
    static {
        try {
            tremplinImage = ImageIO.read(new File("src/images/pieges/tremplin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image pieceImage;
    static {
        try {
            pieceImage = ImageIO.read(new File("src/images/pieges/piece.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image tunnelImage;
    static {
        try {
            tunnelImage = ImageIO.read(new File("src/images/pieges/tunnel.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Image tunnelImage2;
    static {
        try {
            tunnelImage2 = ImageIO.read(new File("src/images/pieges/tunnel2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Frogs

    public static Image frogImage;
    static {
        try {
            frogImage = ImageIO.read(new File("src/images/frogs/frog_one/frog.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image frogImage2;
    static {
        try {
            frogImage2 = ImageIO.read(new File("src/images/frogs/frog_two/frog2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Grass line
    public static Image grassImage;
    static {
        try {
            grassImage = ImageIO.read(new File("src/images/grass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Right obstacles
    public static Image blueTruckImageRight1;
    static {
        try {
            blueTruckImageRight1 = ImageIO.read(new File("src/images/road_obstacles/right/blue_truck_right1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image blueTruckImageRight2;
    static {
        try {
            blueTruckImageRight2 = ImageIO.read(new File("src/images/road_obstacles/right/blue_truck_right2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image greenCarImageRight;
    static {
        try {
            greenCarImageRight = ImageIO.read(new File("src/images/road_obstacles/right/green_car_right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image redBikeImageRight;
    static {
        try {
            redBikeImageRight = ImageIO.read(new File("src/images/road_obstacles/right/red_bike_right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image redCarImageRight;
    static {
        try {
            redCarImageRight = ImageIO.read(new File("src/images/road_obstacles/right/red_car_right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Frog 1

    public static Image frogDownImage;
    static {
        try {
            frogDownImage = ImageIO.read(new File("src/images/frogs/frog_one/frog_down.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image frogLeftImage;
    static {
        try {
            frogLeftImage = ImageIO.read(new File("src/images/frogs/frog_one/frog_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image frogRightImage;
    static {
        try {
            frogRightImage = ImageIO.read(new File("src/images/frogs/frog_one/frog_right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Frog 2

    public static Image frogDownImage2;
    static {
        try {
            frogDownImage2 = ImageIO.read(new File("src/images/frogs/frog_two/frog2_down.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image frogLeftImage2;
    static {
        try {
            frogLeftImage2 = ImageIO.read(new File("src/images/frogs/frog_two/frog2_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image frogRightImage2;
    static {
        try {
            frogRightImage2 = ImageIO.read(new File("src/images/frogs/frog_two/frog2_right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static Image whiteCarImageRight;
    static {
        try {
            whiteCarImageRight = ImageIO.read(new File("src/images/road_obstacles/right/white_car_right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Environment graphics
    public static Image water;
    static{
        try {
            water = ImageIO.read(new File("src/images/water1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image road;
    static {
        try {
            road = ImageIO.read(new File("src/images/road.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Water obstacles
    // Water left obstacles

    public static Image logTwoImageLeft;
    static {
        try {
            logTwoImageLeft = ImageIO.read(new File("src/images/water_obstacles/left/log2_left1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image logTwoImageLeft2;
    static {
        try {
            logTwoImageLeft2 = ImageIO.read(new File("src/images/water_obstacles/left/log2_left2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image logThreeImageLeft;
    static {
        try {
            logThreeImageLeft = ImageIO.read(new File("src/images/water_obstacles/left/log_left1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image logThreeImageLeft2;
    static {
        try {
            logThreeImageLeft2 = ImageIO.read(new File("src/images/water_obstacles/left/log_left2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image logThreeImageLeft3;
    static {
        try {
            logThreeImageLeft3 = ImageIO.read(new File("src/images/water_obstacles/left/log_left3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image turtleImageLeft;
    static {
        try {
            turtleImageLeft = ImageIO.read(new File("src/images/water_obstacles/left/turtle_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Water obstacles
    // Water right obstacles

    public static Image logTwoImageRight;
    static {
        try {
            logTwoImageRight = ImageIO.read(new File("src/images/water_obstacles/left/log2_left1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image logTwoImageRight2;
    static {
        try {
            logTwoImageRight2 = ImageIO.read(new File("src/images/water_obstacles/left/log2_left2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image logThreeImageRight;
    static {
        try {
            logThreeImageRight = ImageIO.read(new File("src/images/water_obstacles/left/log_left1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image logThreeImageRight2;
    static {
        try {
            logThreeImageRight2 = ImageIO.read(new File("src/images/water_obstacles/left/log_left2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image logThreeImageRight3;
    static {
        try {
            logThreeImageRight3 = ImageIO.read(new File("src/images/water_obstacles/left/log_left3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image turtleImageRight;
    static {
        try {
            turtleImageRight = ImageIO.read(new File("src/images/water_obstacles/left/turtle_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
