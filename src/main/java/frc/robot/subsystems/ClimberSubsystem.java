// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config;

public class ClimberSubsystem extends SubsystemBase {

    private CANSparkMax climberMotor;
    
    public static ClimberSubsystem instance;
    public static ClimberSubsystem getInstance() {
        if (instance == null) {
            instance = new ClimberSubsystem();
        }
        return instance;
    }

    private ClimberSubsystem() {
        climberMotor = new CANSparkMax(Config.climberMotorCanID, MotorType.kBrushless);
    }

    /**
     * Set a percentage of battery to output. No PID.
     * 
     * @param percent Between -1.0 and 1.0
     */
    public void percentOutput(double percent) {
        climberMotor.set(percent);
    }

    public void stopMotor() {
        climberMotor.stopMotor();
    }
}
