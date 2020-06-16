package com.example.nutrimeter.data.model.usda.common;

import java.util.List;

public class NutrientAnalysisDetails {

    public static final String NUTRIENT_ANALYSIS_DETAILS_FIELD_SUB_SAMPLE_ID = "subSampleId";
    public static final String NUTRIENT_ANALYSIS_DETAILS_FIELD_AMOUNT = "amount";
    public static final String NUTRIENT_ANALYSIS_DETAILS_FIELD_NUTRIENT_ID = "nutrientId";
    public static final String NUTRIENT_ANALYSIS_DETAILS_FIELD_LAB_METHOD_DESCRIPTION = "labMethodDescription";
    public static final String NUTRIENT_ANALYSIS_DETAILS_FIELD_LAB_METHOD_LINK = "labMethodLink";
    public static final String NUTRIENT_ANALYSIS_DETAILS_FIELD_LAB_METHOD_TECHNIQUE = "labMethodTechnique";
    public static final String NUTRIENT_ANALYSIS_DETAILS_FIELD_NUTRIENT_ACQUISITION_DETAILS = "nutrientAcquisitionDetails";

    private int subSampleId;
    private float amount;
    private int nutrientId;
    private String labMethodDescription;
    private String labMethodLink;
    private String labMethodTechnique;
    private List<NutrientAcquisitionDetails> nutrientAcquisitionDetails;

    public NutrientAnalysisDetails(int subSampleId, float amount, int nutrientId, String labMethodDescription, String labMethodLink, String labMethodTechnique, List<NutrientAcquisitionDetails> nutrientAcquisitionDetails) {
        this.subSampleId = subSampleId;
        this.amount = amount;
        this.nutrientId = nutrientId;
        this.labMethodDescription = labMethodDescription;
        this.labMethodLink = labMethodLink;
        this.labMethodTechnique = labMethodTechnique;
        this.nutrientAcquisitionDetails = nutrientAcquisitionDetails;
    }

    public int getSubSampleId() {
        return subSampleId;
    }

    public float getAmount() {
        return amount;
    }

    public int getNutrientId() {
        return nutrientId;
    }

    public String getLabMethodDescription() {
        return labMethodDescription;
    }

    public String getLabMethodLink() {
        return labMethodLink;
    }

    public String getLabMethodTechnique() {
        return labMethodTechnique;
    }

    public List<NutrientAcquisitionDetails> getNutrientAcquisitionDetails() {
        return nutrientAcquisitionDetails;
    }
}
