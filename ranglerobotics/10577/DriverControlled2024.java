package org.firstinspires.ftc;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;
import java.util.ArrayList;

@TeleOp
public class DriverControlled extends OpMode 
{
    
    //DEFINE robot 
    RobotHardware robot = new RobotHardware();
    
    // CONSTANTS

    //RUN ONCE ON init() 
    public void init() {
        robot.init(hardwareMap); 
        telemetry.addData("STATUS", "Hello Driver");
        
    }

    // LOOP ON init()
    @Override
    
    public void init_loop(){
    }
    
    // RUN ONCE ON start()
    @Override
    public void start(){  
    }    

    
    //LOOP ON start()
    @Override
    //We want to add the Servo controls  onto the Gamepad2
    public void loop(){
        double G1rightStickY = gamepad1.right_stick_y;
        double G1leftStickY = gamepad1.left_stick_y;
        boolean G1rightBumper = gamepad1.right_bumper;
        boolean G1leftBumper = gamepad1.left_bumper;
        float G2rightTrigger = gamepad2.right_trigger;
        double G2rightStickY = gamepad2.right_stick_y;
        double G2leftStickY = gamepad2.left_stick_y;
        
  //We want to add the Servo Motor to open and close the Claw
   if (G1rightBumper) {
            robot.backLeft.setPower(1);
            robot.frontLeft.setPower(-1);
            robot.backRight.setPower(1);
            robot.frontRight.setPower(-1);
            
        }
        else if (G1leftBumper){
            robot.backLeft.setPower(-1);
            robot.frontLeft.setPower(1);
            robot.backRight.setPower(-1);
            robot.frontRight.setPower(1);
            
        }
       
        else {
            robot.backLeft.setPower(G1leftStickY);
            robot.frontLeft.setPower(G1leftStickY);
            robot.backRight.setPower(-G1rightStickY);
            robot.frontRight.setPower(-G1rightStickY);
            robot.InTake.setPower(G2rightTrigger);
            robot.InTake.setPower(G2leftTrigger);
            robot.Arm.setPower(G2leftStickY);
            robot.Arm.setPower(G2rightStickY);  
        }
        }
        
}
     
