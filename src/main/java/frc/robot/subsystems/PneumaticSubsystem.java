
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class PneumaticSubsystem extends SubsystemBase {

  Compressor compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
  DoubleSolenoid climbSolenoid;

  public PneumaticSubsystem() {
    climbSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    init();
  }

  // sets default mode of the compressor
  public void init() {

    if (compressor != null) {
      compressor.enableDigital();
    }
    if (climbSolenoid != null) {
      climbSolenoid.set(kReverse);
    }
  }

  // Enables or Disables the Compressor depending on its current state
  public void toggleCompressor() {
    if (compressor.enabled()) {
      compressor.disable();
    } else {
      compressor.enableDigital();
    }
  }
// Enables or Disables the pneumatic depending on its current state
  public void toggleSolenoid() {
    climbSolenoid.toggle();
  }

  // updates smartdashboard
  @Override
  public void periodic() {
    if (compressor != null) {
      SmartDashboard.putBoolean("Compressor", compressor.enabled());
      SmartDashboard.putBoolean("Compressor Enabled", compressor.getPressureSwitchValue());
    } else {
      SmartDashboard.putBoolean("Compressor", false);
      SmartDashboard.putBoolean("Compressor Enabled", false);
    }
  }
}
