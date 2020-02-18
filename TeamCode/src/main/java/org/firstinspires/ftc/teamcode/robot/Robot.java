package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Basic Robot that wraps all robot functionality
 * @author Jeffrey
 * @since 2/16/20
 * @version 1.0
 */
public class Robot
{
    ///////////////////Drive Motors////////hardware map name // Hub # // Port # // Type ///////
    private static final String FRDRIVE = "frontRightDrive"; //  1    //   0    // Matrix
    private static final String FLDRIVE = "frontRightDrive"; //  1    //   1    // Matrix
    private static final String BRDRIVE = "frontRightDrive"; //  1    //   2    // Matrix
    private static final String BLDRIVE = "frontRightDrive"; //  1    //   3    // Matrix

    private static final double DRIVECPR = 386.3; // counts per rotation
    private static final double GEARRATIO = 2;
    private static final double WHEELDIAMETER = 4;//inches
    private static final double COUNTSPERINCH = (DRIVECPR * GEARRATIO) / (WHEELDIAMETER * Math.PI);

    public DcMotor frontRightDrive, frontLeftDrive, backRightDrive, backLeftDrive;

    public Robot()
    {

    }

    public void initializeHardware(HardwareMap hMap)
    {
        // map to hardware for drive motors;
        frontRightDrive = hMap.get(DcMotor.class, FRDRIVE);
        frontLeftDrive  = hMap.get(DcMotor.class, FLDRIVE);
        backRightDrive  = hMap.get(DcMotor.class, BRDRIVE);
        backLeftDrive   = hMap.get(DcMotor.class, BLDRIVE);


        // set Zero Power Mode for drive motors;
        frontRightDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.BRAKE );
        frontLeftDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.BRAKE);
        backRightDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.BRAKE );
        backLeftDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.BRAKE );

        initializeMotorDirections();
    }

    public void initializeMotorDirections()
    {
        // set direction for drive motors;
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
    }

    public void stopAndResetDriveEncoders()
    {
        frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void startDriveEncoders()
    {
        frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setRightDriveTargetPosition(int position)
    {
        frontRightDrive.setTargetPosition(position);
        backRightDrive.setTargetPosition(position);
    }

    public void setLeftDriveTargetPosition(int position)
    {
        frontLeftDrive.setTargetPosition(position);
        backLeftDrive.setTargetPosition(position);
    }

    public void setDriveTargetPosition(int position)
    {
        setRightDriveTargetPosition(position);
        setLeftDriveTargetPosition(position);
    }

    public int distanceToTicks(double inches)
    {
        return (int)(inches * COUNTSPERINCH);
    }

    public void setRightDriveTargetDistance(double inches)
    {
        frontRightDrive.setTargetPosition(frontRightDrive.getCurrentPosition() + distanceToTicks(inches));
        backRightDrive.setTargetPosition(backRightDrive.getCurrentPosition() + distanceToTicks(inches));
    }

    public void setLeftDriveTargetDistance(double inches)
    {
        frontLeftDrive.setTargetPosition(frontLeftDrive.getCurrentPosition() + distanceToTicks(inches));
        backLeftDrive.setTargetPosition(backLeftDrive.getCurrentPosition() + distanceToTicks(inches));
    }

    public void setDriveTargetDistance(double inches)
    {
        setRightDriveTargetDistance(inches);
        setLeftDriveTargetDistance(inches);
    }


    public void runToPosition()
    {
        frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public boolean driveIsBusy()
    {
        return frontLeftDrive.isBusy() && frontRightDrive.isBusy() && backLeftDrive.isBusy() && backRightDrive.isBusy();
    }

    public void drive(double power)
    {
        rightDrive(power);
        leftDrive(power);
    }

    public void rightDrive(double power)
    {
        frontRightDrive.setPower(power);
        backRightDrive.setPower(power);
    }

    public void leftDrive(double power)
    {
        frontLeftDrive.setPower(power);
        backLeftDrive.setPower(power);
    }

    public void strafe(double power)
    {
        frontRightDrive.setPower(-power);
        frontLeftDrive.setPower(power);
        backRightDrive.setPower(power);
        backLeftDrive.setPower(-power);
    }
}
