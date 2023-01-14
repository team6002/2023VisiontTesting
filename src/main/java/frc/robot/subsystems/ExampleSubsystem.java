// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {}

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public double getY() {
    // Query some boolean state, such as a digital sensor.
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tiy").getDouble(0);
  }
  double[] dv = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
  
  //calculate distance
  @Override
  public void periodic() {
  getY();
  double[] botpose =  NetworkTableInstance.getDefault().getTable("limelight").getEntry("camtran").getDoubleArray(dv);
  
    // This method will be called once per scheduler 
  SmartDashboard.putNumber("BotX", Units.metersToInches(botpose[0]));
  SmartDashboard.putNumber("Boty", Units.metersToInches(botpose[1]));
  SmartDashboard.putNumber("BotZ", Units.metersToInches(botpose[2]));
  SmartDashboard.putNumber("Bot1", Units.metersToInches(botpose[3]));
  SmartDashboard.putNumber("Bot2", Units.metersToInches(botpose[4]));
  SmartDashboard.putNumber("Bot3", Units.metersToInches(botpose[5]));  
  SmartDashboard.putNumber("ID", NetworkTableInstance.getDefault().getTable("limelight").getEntry("tid").getDouble(0));
  // SmartDashboard.putNumberArray("ROBOTLOCATON", NetworkTableInstance.getDefault().getTable("limelight").getEntry("botpose").getDoubleArray(dv));
  SmartDashboard.putNumber("X", NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0));
  SmartDashboard.putNumber("Y", NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0));
  SmartDashboard.putNumber("DO YOU SEE ANYTHING ", NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0));
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
