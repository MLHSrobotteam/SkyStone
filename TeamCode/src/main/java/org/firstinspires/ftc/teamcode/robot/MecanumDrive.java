package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This class is a representation of the Mecanum Drive Train.
 * It includes methods for simple driving, turning, strafing and Encoders support.
 * Before this class can be used, initialization of hardware, direction, zero power behavior should be performed
 * @author Jeffrey
 * @since 2/17/2020
 * @version 1.0
 */
public class MecanumDrive
{
    //////////////////// Drive Motors ////////////// Hardware Map Name // Hub # // Port # // Type ///////
    private static final String FRONT_RIGHT_DRIVE = "frontRightDrive"; //  1    //   0    // Matrix
    private static final String FRONT_LEFT_DRIVE  = "frontLeftDrive";  //  1    //   1    // Matrix
    private static final String BACK_RIGHT_DRIVE  = "backRightDrive";  //  1    //   2    // Matrix
    private static final String BACK_LEFT_DRIVE   = "backLeftDrive";   //  1    //   3    // Matrix

    public static final double DRIVE_CPR = 386.3; // counts per rotation
    public static final double GEAR_RATIO = 0.5; // geared down 2:1
    public static final double WHEEL_DIAMETER = 4;//inches
    public static final double COUNTS_PER_INCH = (DRIVE_CPR * GEAR_RATIO) / (WHEEL_DIAMETER * Math.PI);

    public DcMotor frontRightDrive, frontLeftDrive, backRightDrive, backLeftDrive;

    public void initializeHardware(HardwareMap hMap)
    {
        frontRightDrive = hMap.get( DcMotor.class, FRONT_RIGHT_DRIVE );
        frontLeftDrive = hMap.get( DcMotor.class, FRONT_LEFT_DRIVE );
        backRightDrive = hMap.get( DcMotor.class, BACK_RIGHT_DRIVE );
        backLeftDrive = hMap.get( DcMotor.class, BACK_LEFT_DRIVE );
    }

    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior zeroPowerBehavior)
    {
        switch (zeroPowerBehavior)
        {
            case BRAKE:
                frontRightDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.BRAKE );
                frontLeftDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.BRAKE );
                backRightDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.BRAKE );
                backLeftDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.BRAKE );
                break;
            case FLOAT:
                frontRightDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.FLOAT );
                frontLeftDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.FLOAT );
                backRightDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.FLOAT );
                backLeftDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.FLOAT );
                break;
            case UNKNOWN:
                frontRightDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.UNKNOWN );
                frontLeftDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.UNKNOWN );
                backRightDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.UNKNOWN );
                backLeftDrive.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.UNKNOWN );
                break;
        }
    }

    public void setNaturalDirection(DcMotorSimple.Direction direction)
    {
        switch (direction)
        {
            case FORWARD:
                frontRightDrive.setDirection( DcMotor.Direction.FORWARD );
                frontLeftDrive.setDirection( DcMotor.Direction.FORWARD );
                backRightDrive.setDirection( DcMotor.Direction.FORWARD );
                backLeftDrive.setDirection( DcMotor.Direction.FORWARD );
                break;
            case REVERSE:
                frontRightDrive.setDirection( DcMotor.Direction.REVERSE );
                frontLeftDrive.setDirection( DcMotor.Direction.REVERSE );
                backRightDrive.setDirection( DcMotor.Direction.REVERSE );
                backLeftDrive.setDirection( DcMotor.Direction.REVERSE );
                break;
        }
    }

    public void setDriveDirection(DcMotorSimple.Direction direction)
    {
        switch (direction)
        {
            case FORWARD:
                frontRightDrive.setDirection( DcMotor.Direction.REVERSE );
                frontLeftDrive.setDirection( DcMotor.Direction.FORWARD );
                backRightDrive.setDirection( DcMotor.Direction.REVERSE );
                backLeftDrive.setDirection( DcMotor.Direction.FORWARD );
                break;
            case REVERSE:
                frontRightDrive.setDirection( DcMotor.Direction.FORWARD );
                frontLeftDrive.setDirection( DcMotor.Direction.REVERSE );
                backRightDrive.setDirection( DcMotor.Direction.FORWARD );
                backLeftDrive.setDirection( DcMotor.Direction.REVERSE );
                break;
        }
    }

    public void setDriveMode(DcMotor.RunMode mode)
    {
        switch(mode) {
            case STOP_AND_RESET_ENCODER:
                frontRightDrive.setMode( DcMotor.RunMode.STOP_AND_RESET_ENCODER );
                frontLeftDrive.setMode( DcMotor.RunMode.STOP_AND_RESET_ENCODER );
                backRightDrive.setMode( DcMotor.RunMode.STOP_AND_RESET_ENCODER );
                backLeftDrive.setMode( DcMotor.RunMode.STOP_AND_RESET_ENCODER );
                break;
            case RUN_USING_ENCODER:
                frontRightDrive.setMode( DcMotor.RunMode.RUN_USING_ENCODER );
                frontLeftDrive.setMode( DcMotor.RunMode.RUN_USING_ENCODER );
                backRightDrive.setMode( DcMotor.RunMode.RUN_USING_ENCODER );
                backLeftDrive.setMode( DcMotor.RunMode.RUN_USING_ENCODER );
                break;
            case RUN_WITHOUT_ENCODER:
                frontRightDrive.setMode( DcMotor.RunMode.RUN_WITHOUT_ENCODER );
                frontLeftDrive.setMode( DcMotor.RunMode.RUN_WITHOUT_ENCODER );
                backRightDrive.setMode( DcMotor.RunMode.RUN_WITHOUT_ENCODER );
                backLeftDrive.setMode( DcMotor.RunMode.RUN_WITHOUT_ENCODER );
                break;
            case RUN_TO_POSITION:
                frontRightDrive.setMode( DcMotor.RunMode.RUN_TO_POSITION );
                frontLeftDrive.setMode( DcMotor.RunMode.RUN_TO_POSITION );
                backRightDrive.setMode( DcMotor.RunMode.RUN_TO_POSITION );
                backLeftDrive.setMode( DcMotor.RunMode.RUN_TO_POSITION );
                break;
        }
    }

    public boolean isBusy() {
        return frontLeftDrive.isBusy()
                && frontRightDrive.isBusy()
                && backLeftDrive.isBusy()
                && backRightDrive.isBusy();
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

    public void turn(double power)
    {
        rightDrive(power);
        leftDrive(-power);
    }

    public void setLeftTargetPosition(int position)
    {
        frontLeftDrive.setTargetPosition(position);
        backLeftDrive.setTargetPosition(position);
    }

    public void setRightTargetPosition(int position)
    {
        frontRightDrive.setTargetPosition(position);
        backRightDrive.setTargetPosition(position);
    }

    public void setDriveTargetPosition(int position)
    {
        setRightTargetPosition(position);
        setLeftTargetPosition(position);
    }

    public void setRightTargetDistance(double inches)
    {
        int ticks = driveMotorDistToTick(inches);
        frontRightDrive.setTargetPosition(frontRightDrive.getCurrentPosition() + ticks);
        backRightDrive.setTargetPosition(backRightDrive.getCurrentPosition() + ticks);
    }

    public void setLeftTargetDistance(double inches)
    {
        int ticks = driveMotorDistToTick(inches);
        frontLeftDrive.setTargetPosition(frontLeftDrive.getCurrentPosition() + ticks);
        backLeftDrive.setTargetPosition(backLeftDrive.getCurrentPosition() + ticks);
    }

    public void setTargetDistance(double inches)
    {
        setRightTargetDistance(inches);
        setLeftTargetDistance(inches);
    }

    public int driveMotorDistToTick(double inches)
    {
        return (int)(inches * COUNTS_PER_INCH);
    }

    public void doEncoderDrive(double inches, double power, boolean opModeActive, ElapsedTime netTime, double timeout)
    {
        ElapsedTime runtime = new ElapsedTime();
        setDriveMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);

        setTargetDistance(inches);
        runtime.reset();
        setDriveMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(opModeActive && runtime.seconds() <= timeout && isBusy() && netTime.seconds() < 30)
            drive(power);

        drive(0);
    }

    public String toString()
    {
        return "Front Right: " + frontRightDrive.getCurrentPosition() + "\n" +
                "Front Left: " + frontLeftDrive.getCurrentPosition() + "\n" +
                "Back Right: " + backRightDrive.getCurrentPosition() + "\n" +
                "Back Left: " + backLeftDrive.getCurrentPosition();
    }
}
