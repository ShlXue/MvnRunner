package com.lightd.ideap.maven.settings;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.options.UnnamedConfigurable;
import com.intellij.openapi.project.Project;
import com.lightd.ideap.maven.MvnBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.idea.maven.project.AdditionalMavenImportingSettings;

import javax.swing.*;

public class MvnRunConfigurable implements AdditionalMavenImportingSettings, SearchableConfigurable {

    private final MvnRunConfigurationSettings mySettings = new MvnRunConfigurationSettings(true);
    private final MvnRunConfigurationSettingsPanel settingsPanel = new MvnRunConfigurationSettingsPanel();

    @Nls
    @Override
    public String getDisplayName() {
        return MvnBundle.message("configurable.display.name");
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return settingsPanel;
    }

    @Override
    public boolean isModified() {
        return settingsPanel.isModified(mySettings);
    }

    @Override
    public void apply() throws ConfigurationException {
        settingsPanel.getData(mySettings);
    }

    @Override
    public void reset() {
        settingsPanel.setData(mySettings);
    }

    @Override
    public void disposeUIResources() {
    }

    @Nullable
    @Override
    public Runnable enableSearch(String s) {
        return null;
    }

    @NotNull
    @Override
    public String getId() {
        return MvnBundle.message("configurable.id");
    }

    @Override
    public UnnamedConfigurable createConfigurable(Project project) {
        return this;
    }
}
