/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSubsystem extends SubsystemBase {
  private Encoder encoder1;

  private WPI_TalonSRX talon1 = new WPI_TalonSRX(14);//left support
  private WPI_TalonSRX talon2 = new WPI_TalonSRX(10);//left main
  private WPI_TalonSRX talon3 = new WPI_TalonSRX(15);// right main
  private WPI_TalonSRX talon4 = new WPI_TalonSRX(11);//right slave not main

  private MotorControllerGroup left = new MotorControllerGroup(talon1, talon2);
  private MotorControllerGroup right = new MotorControllerGroup(talon3, talon4);

  private DifferentialDrive drive = new DifferentialDrive(left, right);

  public void arcadeDrive(double power, double rotation) {
    drive.arcadeDrive(power, rotation);
  }

  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    talon2.setInverted(false);
    talon4.setInverted(false);
    talon1.setInverted(false);
    talon3.setInverted(false);

    encoder1 = new Encoder(0,1);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    System.out.println("" +  talon1.getSelectedSensorVelocity() + "\n" + talon2.getSelectedSensorVelocity());
    System.out.println("" + encoder1.get());
  }
}
