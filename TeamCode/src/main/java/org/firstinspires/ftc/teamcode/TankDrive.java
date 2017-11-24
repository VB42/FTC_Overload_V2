package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * This class allows the driver controlled operation of the robot.
 * 
 *
 *
 *
 *
 */

@TeleOp(name="TankDrive", group="Test")
public class TankDrive extends OpMode
{

    private DcMotorController control;
    private DcMotorController control2;
    private ServoController servoController;
    //private DcMotorController control2;
    private DcMotor left_front;
    private DcMotor right_front;
    private DcMotor left_back;
    private DcMotor right_back;
    private Servo LiftL;
    private Servo LiftR;
    private Servo ClawL;
    private Servo ClawR;
    private ColorSensor color_sensor;
    public static double threshold = 0.2;

    @Override
    public void init()
    {
        control = hardwareMap.dcMotorController.get("drive_controller");
       // servoController = hardwareMap.servoController.get("servo_controller");
        left_front = hardwareMap.dcMotor.get("left_front");
        right_front = hardwareMap.dcMotor.get("right_front");

        control2 = hardwareMap.dcMotorController.get("drive_controller2");


        left_back = hardwareMap.dcMotor.get("left_back");
        right_back = hardwareMap.dcMotor.get("right_back");

        //LiftL=hardwareMap.servo.get("LiftL");
       // ClawL=hardwareMap.servo.get("ClawL");
        //ClawR=hardwareMap.servo.get("ClawR");

        //LiftR=hardwareMap.servo.get("LiftR");
        color_sensor = hardwareMap.colorSensor.get("color");
        color_sensor.enableLed(true);

    }
    //Helper method for resetting all motors to a stop
    public void resetMotors(){
        left_front.setPower(0);
        left_back.setPower(0);
        right_front.setPower(0);
        right_back.setPower(0);
    }

    //Helper method for logging values to screens
    public void log(String main, String val){
        telemetry.addData(main, val);
    }

    @Override
    public void loop() throws IllegalArgumentException
    {

        int red = color_sensor.red();

        log("SayRed", Integer.toString(red));


        int blue = color_sensor.blue();

        log("SayBlue", Integer.toString(blue));


         /*
          *  Checks if the y value is forward or backwards.
          *  The y values are reversed so we have to negate it to logically use it.
          *
          */
        if(Math.abs(gamepad1.left_stick_y) > threshold){
            left_front.setPower(Math.pow(-gamepad1.left_stick_y, 3));
            left_back.setPower(Math.pow(-gamepad1.left_stick_y, 3));
            log("Left Stick Y", Float.toString(-gamepad1.left_stick_y));

        }


         /*
          *  Checks if the y value is forward or backwards.
          *
          */
        if(Math.abs(gamepad1.right_stick_y) > threshold){
            right_front.setPower(Math.pow(gamepad1.right_stick_y, 3));
            right_back.setPower(Math.pow(gamepad1.right_stick_y, 3));
            log("Right Stick Y", Float.toString(gamepad1.right_stick_y));

        }


        /*
         *  Used for strafing, sets the power to allow sideways movement when shifted to the right
         *
         */
        if(Math.abs(gamepad1.left_stick_x) > threshold && Math.abs(gamepad1.right_stick_x) > threshold){
            left_front.setPower(Math.pow(-gamepad1.left_stick_x, 3));
            left_back.setPower(Math.pow(gamepad1.left_stick_x, 3));
            right_front.setPower(Math.pow(-gamepad1.right_stick_x, 3));
            right_back.setPower(Math.pow(gamepad1.right_stick_x, 3));
            log("Sideways", Float.toString(gamepad1.right_stick_x));
            log("Sideways", Float.toString(gamepad1.left_stick_x));

        }
        /*
         *  Resets motors when the control isn't moving
         *
         */
        if(Math.abs(gamepad1.left_stick_x) < threshold && Math.abs(gamepad1.right_stick_x) < threshold
                && Math.abs(gamepad1.left_stick_y) < threshold && Math.abs(gamepad1.right_stick_y) < threshold){
            resetMotors();
        }


    }
}

