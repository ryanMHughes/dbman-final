package uga.lroc.cs4370.models;

public class ExpandedImage {
    private String imageId;
    private String url;
    private String product;
    private String pdsDatasetName;
    private String pdsVolumeName;
    private String instrumentHost;
    private String instrument;
    private String originalProduct;
    private String productVersion;
    private String missionPhaseName;
    private String rationaleDesc;
    private int dataQuality;
    private String nacPrerollStartTime;
    private String startTime;
    private String stopTime;
    private int spacecraftClockPartition;
    private String nacSpacecraftClockPrerollCount;
    private String spacecraftClockStartCount;
    private String spacecraftClockStopCount;
    private String targetName;
    private int orbitNumber;
    private double slewAngle;
    private String lroNodeCrossing;
    private String lroFlightDirection;
    private double nacLineExposureDuration;
    private String nacFrame;
    private int nacDacReset;
    private int nacChannelAOffset;
    private int nacChannelBOffset;
    private int instrumentModeCode;
    private int compandSelectCode;
    private boolean modeCompression;
    private boolean modeTest;
    private double nacTemperatureScs;
    private double nacTemperatureFpa;
    private double nacTemperatureFpga;
    private double nacTemperatureTelescope;
    private int imageLines;
    private int lineSamples;
    private int sampleBits;
    private double scaledPixelWidth;
    private double scaledPixelHeight;
    private double resolution;
    private double emissionAngle;
    private double incidenceAngle;
    private double phaseAngle;
    private double northAzimuth;
    private double subSolarAzimuth;
    private double subSolarLatitude;
    private double subSolarLongitude;
    private double subSpacecraftLatitude;
    private double subSpacecraftLongitude;
    private double solarDistance;
    private double solarLongitude;
    private double centerLatitude;
    private double centerLongitude;
    private double upperRightLatitude;
    private double upperRightLongitude;
    private double lowerRightLatitude;
    private double lowerRightLongitude;
    private double lowerLeftLatitude;
    private double lowerLeftLongitude;
    private double upperLeftLatitude;
    private double upperLeftLongitude;
    private double spacecraftAltitude;
    private double targetCenterDistance;

    public ExpandedImage(
        String imageId, String url, String product, String pdsDatasetName, String pdsVolumeName,
        String instrumentHost, String instrument, String originalProduct, String productVersion,
        String missionPhaseName, String rationaleDesc, int dataQuality, String nacPrerollStartTime,
        String startTime, String stopTime, int spacecraftClockPartition, String nacSpacecraftClockPrerollCount,
        String spacecraftClockStartCount, String spacecraftClockStopCount, String targetName, int orbitNumber,
        double slewAngle, String lroNodeCrossing, String lroFlightDirection, double nacLineExposureDuration,
        String nacFrame, int nacDacReset, int nacChannelAOffset, int nacChannelBOffset, int instrumentModeCode,
        int compandSelectCode, boolean modeCompression, boolean modeTest, double nacTemperatureScs,
        double nacTemperatureFpa, double nacTemperatureFpga, double nacTemperatureTelescope, int imageLines,
        int lineSamples, int sampleBits, double scaledPixelWidth, double scaledPixelHeight, double resolution,
        double emissionAngle, double incidenceAngle, double phaseAngle, double northAzimuth, double subSolarAzimuth,
        double subSolarLatitude, double subSolarLongitude, double subSpacecraftLatitude, double subSpacecraftLongitude,
        double solarDistance, double solarLongitude, double centerLatitude, double centerLongitude,
        double upperRightLatitude, double upperRightLongitude, double lowerRightLatitude, double lowerRightLongitude,
        double lowerLeftLatitude, double lowerLeftLongitude, double upperLeftLatitude, double upperLeftLongitude,
        double spacecraftAltitude, double targetCenterDistance
    ) {
        this.imageId = imageId;
        this.url = url;
        this.product = product;
        this.pdsDatasetName = pdsDatasetName;
        this.pdsVolumeName = pdsVolumeName;
        this.instrumentHost = instrumentHost;
        this.instrument = instrument;
        this.originalProduct = originalProduct;
        this.productVersion = productVersion;
        this.missionPhaseName = missionPhaseName;
        this.rationaleDesc = rationaleDesc;
        this.dataQuality = dataQuality;
        this.nacPrerollStartTime = nacPrerollStartTime;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.spacecraftClockPartition = spacecraftClockPartition;
        this.nacSpacecraftClockPrerollCount = nacSpacecraftClockPrerollCount;
        this.spacecraftClockStartCount = spacecraftClockStartCount;
        this.spacecraftClockStopCount = spacecraftClockStopCount;
        this.targetName = targetName;
        this.orbitNumber = orbitNumber;
        this.slewAngle = slewAngle;
        this.lroNodeCrossing = lroNodeCrossing;
        this.lroFlightDirection = lroFlightDirection;
        this.nacLineExposureDuration = nacLineExposureDuration;
        this.nacFrame = nacFrame;
        this.nacDacReset = nacDacReset;
        this.nacChannelAOffset = nacChannelAOffset;
        this.nacChannelBOffset = nacChannelBOffset;
        this.instrumentModeCode = instrumentModeCode;
        this.compandSelectCode = compandSelectCode;
        this.modeCompression = modeCompression;
        this.modeTest = modeTest;
        this.nacTemperatureScs = nacTemperatureScs;
        this.nacTemperatureFpa = nacTemperatureFpa;
        this.nacTemperatureFpga = nacTemperatureFpga;
        this.nacTemperatureTelescope = nacTemperatureTelescope;
        this.imageLines = imageLines;
        this.lineSamples = lineSamples;
        this.sampleBits = sampleBits;
        this.scaledPixelWidth = scaledPixelWidth;
        this.scaledPixelHeight = scaledPixelHeight;
        this.resolution = resolution;
        this.emissionAngle = emissionAngle;
        this.incidenceAngle = incidenceAngle;
        this.phaseAngle = phaseAngle;
        this.northAzimuth = northAzimuth;
        this.subSolarAzimuth = subSolarAzimuth;
        this.subSolarLatitude = subSolarLatitude;
        this.subSolarLongitude = subSolarLongitude;
        this.subSpacecraftLatitude = subSpacecraftLatitude;
        this.subSpacecraftLongitude = subSpacecraftLongitude;
        this.solarDistance = solarDistance;
        this.solarLongitude = solarLongitude;
        this.centerLatitude = centerLatitude;
        this.centerLongitude = centerLongitude;
        this.upperRightLatitude = upperRightLatitude;
        this.upperRightLongitude = upperRightLongitude;
        this.lowerRightLatitude = lowerRightLatitude;
        this.lowerRightLongitude = lowerRightLongitude;
        this.lowerLeftLatitude = lowerLeftLatitude;
        this.lowerLeftLongitude = lowerLeftLongitude;
        this.upperLeftLatitude = upperLeftLatitude;
        this.upperLeftLongitude = upperLeftLongitude;
        this.spacecraftAltitude = spacecraftAltitude;
        this.targetCenterDistance = targetCenterDistance;
    }
}
