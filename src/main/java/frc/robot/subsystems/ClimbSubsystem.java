// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {
  private WPI_TalonSRX leftClimbMotor = new WPI_TalonSRX(7);
  private WPI_TalonSRX rightClimbMotor = new WPI_TalonSRX(10);
  /** Creates a new ClimbSubsystem. */
  public ClimbSubsystem() {}

  public void moveMotors(double leftSpeed, double rightSpeed){
    leftClimbMotor.set(leftSpeed);
    rightClimbMotor.set(rightSpeed);
  }
  public void leftclimbon(){
    leftClimbMotor.set(1);

  }
  public void rightclimbon(){
    rightClimbMotor.set(1);
  }
  
  public void leftclimboff(){
    rightClimbMotor.set(0);
  }

  public void rightclimboff(){
    rightClimbMotor.set(0);
  }
  public void rightclimbdown(){
  rightClimbMotor.set(-1);

  }
  public void leftclimbdown(){
    leftClimbMotor.set(-1);
  }  
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
