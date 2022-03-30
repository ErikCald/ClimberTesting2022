// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ClimberSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ClimbCommand extends CommandBase {

    private final ClimberSubsystem m_climberSubsystem;
    private final Supplier<Double> m_percentOutput;

    public ClimbCommand(Supplier<Double> percentOutput) {
        m_climberSubsystem = ClimberSubsystem.getInstance();
        m_percentOutput = percentOutput;
        addRequirements(m_climberSubsystem);
    }

    @Override
    public void execute() {
        m_climberSubsystem.percentOutput(m_percentOutput.get());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_climberSubsystem.stopMotor();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
