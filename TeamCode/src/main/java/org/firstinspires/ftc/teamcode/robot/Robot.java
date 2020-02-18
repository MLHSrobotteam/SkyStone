package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Basic Robot that wraps all robot functionality
 * @author Jeffrey
 * @since 2/17/20
 * @version 1.1
 */
public class Robot
{
    public MecanumDrive driveTrain;

    public Robot()
    {
        driveTrain = new MecanumDrive();
    }

    public void initializeHardware(HardwareMap hMap)
    {
        driveTrain.initializeHardware(hMap);
        driveTrain.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void initializeMotorDirections()
    {
        driveTrain.setDriveDirection(DcMotorSimple.Direction.FORWARD);
    }

    public MecanumDrive getDriveTrain()
    {
        return driveTrain;
    }
}
