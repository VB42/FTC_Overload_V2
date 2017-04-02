package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

/**
 * Created by Vinay on 2/25/17.
 */
public class Testv1 extends OpMode{

    private DcMotorController control;

    private DcMotor left;
    private DcMotor right;

    @Override
    public void init() {

        control = hardwareMap.dcMotorController.get("drive_controller");
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");


    }

    @Override
    public void loop(){

        left.setPower(-gamepad1.left_stick_y);
        right.setPower(-gamepad2.right_stick_y);

    }
}
