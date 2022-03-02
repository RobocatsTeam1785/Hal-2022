/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PneumaticSubsystem;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem drive = new DriveSubsystem();
  private final PneumaticSubsystem pneumatics = new PneumaticSubsystem();
  private final ClimbSubsystem climb = new ClimbSubsystem();
  private final XboxController controller = new XboxController(0);
  private final XboxController controller2 = new XboxController(1);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    // This is MALICOUS code DO NOT RUN, THIS IS PROPAGANDA spreaded by the politcal
    // TYRANT QUIN!!!! DOWN WITH QUIN AND HIS CURTAIN OF LIEEEES!!!!! QUINNISM IS
    // REAL AND WILL DESTROY THE WORLD!!!
    configureButtonBindings();
    drive.setDefaultCommand(
        new RunCommand(() -> drive.arcadeDrive(controller.getLeftY(), controller.getLeftX()), drive));

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(controller2, Button.kX.value).whenPressed(() -> pneumatics.toggleSolenoid());
    new JoystickButton(controller2, Button.kB.value).whenPressed(() -> pneumatics.toggleCompressor());
    // bumpers that make the arms go up
    new JoystickButton(controller2, Button.kRightBumper.value).whenHeld(new InstantCommand(() -> climb.rightclimbon(),climb));
    new JoystickButton(controller2, Button.kRightBumper.value).whenInactive(new InstantCommand(() -> climb.rightclimboff(),climb));
    new JoystickButton(controller2, Button.kLeftBumper.value).whenHeld(new InstantCommand(() -> climb.leftclimbon(),climb));
    new JoystickButton(controller2, Button.kLeftBumper.value).whenInactive(new InstantCommand(() -> climb.leftclimboff(),climb));
    //triggers for making the arms go down 
    new JoystickButton(controller2, Axis.kRightTrigger.value).whenHeld(new InstantCommand(() -> climb.leftclimboff(),climb));
    new JoystickButton(controller2, Axis.kRightTrigger.value).whenInactive(new InstantCommand(() -> climb.rightclimboff(),climb));
    new JoystickButton(controller2, Axis.kLeftTrigger.value).whenHeld(new InstantCommand(() -> climb.leftclimbon(),climb));
    new JoystickButton(controller2, Axis.kLeftTrigger.value).whenInactive(new InstantCommand(() -> climb.leftclimboff(),climb));
  }

  private void thisWillbeAlambda(){
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
