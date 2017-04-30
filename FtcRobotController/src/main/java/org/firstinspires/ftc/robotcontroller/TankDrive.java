package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Vinay on 2/25/17.
 */


//yash is a cool kid

@TeleOp(name="TankDrive", group="Test")
public class TankDrive extends OpMode{

    private DcMotorController control;

    private DcMotor left;
    private DcMotor right;

    public static double threshold = 0.2;

    @Override
    public void init() {

        control = hardwareMap.dcMotorController.get("drive_controller");
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");




    }

    @Override
    public void loop(){

        telemetry.addData("Say", "Hello");

        if(Math.abs(-gamepad1.left_stick_y) > threshold){
        right.setPower(Math.pow(-gamepad1.right_stick_y, 3));
        }
        if(Math.abs(-gamepad1.right_stick_y) > threshold){
        right.setPower(-1*Math.pow(-gamepad1.right_stick_y, 3));
        }

       if(Math.abs(-gamepad1.left_stick_y) < threshold && Math.abs(-gamepad1.right_stick_y) < threshold){
        right.setPower(0);
        left.setPower(0);
       }

    }
}
