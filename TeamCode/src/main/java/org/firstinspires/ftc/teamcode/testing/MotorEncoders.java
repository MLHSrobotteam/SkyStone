/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.Robot;

@TeleOp(name="Motor Encoders Test V1.0", group="Auto")
//@Disabled
public class MotorEncoders extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private ElapsedTime totalRuntime = new ElapsedTime();
    Robot robot = new Robot();

    @Override
    public void runOpMode()
    {
        robot.initializeHardware(hardwareMap);

        waitForStart();
        runtime.reset();
        totalRuntime.reset();
        robot.stopAndResetDriveEncoders();
        robot.startDriveEncoders();

        while (opModeIsActive() && totalRuntime.seconds() < 30 )
        {
            robot.setDriveTargetDistance(12.0); //<-- in inches
            runtime.reset();
            robot.runToPosition();
            robot.drive(0.5);

            while(opModeIsActive() && runtime.seconds() < 5 && robot.driveIsBusy())
            {
                telemetry.addData("Path1",  "Front Right %7d", robot.frontRightDrive.getCurrentPosition());
                telemetry.addData("Path2",  "Front Left  %7d", robot.frontLeftDrive.getCurrentPosition());
                telemetry.addData("Path3",  "Back Right %7d", robot.backRightDrive.getCurrentPosition());
                telemetry.addData("Path4",  "Back Left  %7d", robot.backLeftDrive.getCurrentPosition());
            }

            robot.drive(0);
        }
    }
}
