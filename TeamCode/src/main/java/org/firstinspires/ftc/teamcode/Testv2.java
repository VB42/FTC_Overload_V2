package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

/**
 * Created by Vinay on 2/25/17.
 */


//yash is

@TeleOp(name="Testv2", group="Test")
public class Testv2 extends OpMode{

    private DcMotorController control;

    private DcMotor left;
    private DcMotor right;

    public static double deadArvind = 0.2;

    @Override
    public void init() {

        control = hardwareMap.dcMotorController.get("drive_controller");
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");




    }

    @Override
    public void loop(){

        telemetry.addData("Say", "Hello");

        if(-gamepad1.left_stick_y > deadArvind){
            left.setPower(Math.pow(-gamepad1.left_stick_y, 3));
        }

        if(-gamepad1.right_stick_y > deadArvind){
            right.setPower(Math.pow(-gamepad1.right_stick_y, 3));
        }







    }
}
