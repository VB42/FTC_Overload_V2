package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Vinay on 2/25/17.
 */

@TeleOp(name="TankDrive", group="Test")
public class TankDrive extends OpMode
{

    private DcMotorController control;
    private ServoController servoController;
    //private DcMotorController control2;
    private DcMotor left;
    private DcMotor right;
    private Servo LiftL;
    private Servo LiftR;
    private Servo ClawL;
    private Servo ClawR;
    private ColorSensor color_sensor;
    public static double threshold = 0.1;

    @Override
    public void init()
    {
        control = hardwareMap.dcMotorController.get("drive_controller");
        servoController = hardwareMap.servoController.get("servo_controller");
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        LiftL=hardwareMap.servo.get("LiftL");
        ClawL=hardwareMap.servo.get("ClawL");
        ClawR=hardwareMap.servo.get("ClawR");
        //control2 = hardwareMap.dcMotorController.get("drive_controller2");
        LiftR=hardwareMap.servo.get("LiftR");
        color_sensor = hardwareMap.colorSensor.get("color");
        color_sensor.enableLed(true);

    }
    @Override
    public void loop() throws IllegalArgumentException
    {

        telemetry.addData("Say", "Hello");

        int red = color_sensor.red();

        telemetry.addData("SayRed", red);


        int blue = color_sensor.blue();

        telemetry.addData("SayBlue", blue);



        if(Math.abs(-gamepad1.left_stick_y) > threshold)
        {
            left.setPower(Math.pow(-gamepad1.left_stick_y, 3));
            telemetry.addData("Left Stick Y",Float.toString(gamepad1.left_stick_y));
        }
        else
        {
            left.setPower(0);
        }
        if(Math.abs(-gamepad1.right_stick_y) > threshold)
        {
            right.setPower(-1*Math.pow(-gamepad1.right_stick_y, 3));
            telemetry.addData("Right Stick Y",Float.toString(gamepad1.right_stick_y));
        }
        else
        {
            right.setPower(0);
        }
        if(gamepad1.x)
        {
            LiftL.setPosition(1);
            LiftR.setPosition(0);
            telemetry.addData("Say1", "Lift: x");
        }
        else if(gamepad1.y)
        {
            LiftL.setPosition(0);
            LiftR.setPosition(1);
            telemetry.addData("Say2", "Lift: y");


        }
        else
        {
            LiftL.setPosition(0.5);
            LiftR.setPosition(0.5);
            telemetry.addData("Say3", "Lift: Else");
        }
        if(gamepad1.a)
        {
            ClawL.setPosition(1);
            ClawR.setPosition(0);
            telemetry.addData("Say4", "Claw: a");

        }
        else if(gamepad1.b)
        {
            ClawL.setPosition(0);
            ClawR.setPosition(1);
            telemetry.addData("Say5", "Claw: b");
        }
        else
        {
            ClawL.setPosition(0.5);
            ClawR.setPosition(0.52);
            telemetry.addData("Say6", "Claw: Else");
        }
    }
}

