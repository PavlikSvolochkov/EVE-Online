package logic;

public class SkillInTraining {

    private String currentTQTime;         // Current server time.
    private String trainingEndTime;       // Time when current skill in training will end.
    private String trainingStartTime;     // Time when current skill in training started.
    private String trainingTypeID;        // Type ID of skill being trained.
    private String trainingStartSP;       // Number of skill points character had in this skill when training started.
    private String trainingDestinationSP; // Number of skill points this character will have when training completes.
    private String trainingToLevel;       // Level this skill is being trained to.
    private String skillInTraining;       // 1 if skill in training, 0 otherwise.

    public SkillInTraining() {

    }

    public String getCurrentTQTime() {
        return currentTQTime;
    }

    public void setCurrentTQTime(String currentTQTime) {
        this.currentTQTime = currentTQTime;
    }

    public String getTrainingEndTime() {
        return trainingEndTime;
    }

    public void setTrainingEndTime(String trainingEndTime) {
        this.trainingEndTime = trainingEndTime;
    }

    public String getTrainingStartTime() {
        return trainingStartTime;
    }

    public void setTrainingStartTime(String trainingStartTime) {
        this.trainingStartTime = trainingStartTime;
    }

    public String getTrainingTypeID() {
        return trainingTypeID;
    }

    public void setTrainingTypeID(String trainingTypeID) {
        this.trainingTypeID = trainingTypeID;
    }

    public String getTrainingStartSP() {
        return trainingStartSP;
    }

    public void setTrainingStartSP(String trainingStartSP) {
        this.trainingStartSP = trainingStartSP;
    }

    public String getTrainingDestinationSP() {
        return trainingDestinationSP;
    }

    public void setTrainingDestinationSP(String trainingDestinationSP) {
        this.trainingDestinationSP = trainingDestinationSP;
    }

    public String getTrainingToLevel() {
        return trainingToLevel;
    }

    public void setTrainingToLevel(String trainingToLevel) {
        this.trainingToLevel = trainingToLevel;
    }

    public String getSkillInTraining() {
        return skillInTraining;
    }

    public void setSkillInTraining(String skillInTraining) {
        this.skillInTraining = skillInTraining;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SkillInTraining{");
        sb.append("currentTQTime='").append(currentTQTime).append('\'');
        sb.append(", trainingEndTime='").append(trainingEndTime).append('\'');
        sb.append(", trainingStartTime='").append(trainingStartTime).append('\'');
        sb.append(", trainingTypeID='").append(trainingTypeID).append('\'');
        sb.append(", trainingStartSP='").append(trainingStartSP).append('\'');
        sb.append(", trainingDestinationSP='").append(trainingDestinationSP).append('\'');
        sb.append(", trainingToLevel='").append(trainingToLevel).append('\'');
        sb.append(", skillInTraining='").append(skillInTraining).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
