package org.firstinspires.ftc.teamcode;
import java.lang.Math;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
/**
 * Created by Aneesh Boreda on 4/23/2017.
 */
@TeleOp(name="NormalDrive", group="Test")
public class NormalDrive extends OpMode{
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
            left.setPower(-1*Math.pow(-gamepad1.left_stick_y, 3));
            right.setPower(Math.pow(-gamepad1.right_stick_y, 3));
        }

        else if(Math.abs(-gamepad1.right_stick_x) > threshold){
            right.setPower(Math.pow(-gamepad1.right_stick_x, 3));
            left.setPower(Math.pow(-gamepad1.right_stick_x, 3));
        }







    }
}
