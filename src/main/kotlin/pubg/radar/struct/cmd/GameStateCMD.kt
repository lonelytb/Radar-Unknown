package pubg.radar.struct.cmd

import com.badlogic.gdx.math.Vector2
import pubg.radar.*
import pubg.radar.struct.*
import pubg.radar.struct.cmd.CMD.propertyBool
import pubg.radar.struct.cmd.CMD.propertyByte
import pubg.radar.struct.cmd.CMD.propertyFloat
import pubg.radar.struct.cmd.CMD.propertyInt
import pubg.radar.struct.cmd.CMD.propertyName
import pubg.radar.struct.cmd.CMD.propertyObject
import pubg.radar.struct.cmd.CMD.propertyString
import pubg.radar.struct.cmd.CMD.propertyVector

object GameStateCMD: GameListener {
  init {
    register(this)
  }
  
  override fun onGameOver() {
    SafetyZonePosition.setZero()
    SafetyZoneRadius = 0f
    SafetyZoneBeginPosition.setZero()
    SafetyZoneBeginRadius = 0f
    PoisonGasWarningPosition.setZero()
    PoisonGasWarningRadius = 0f
    RedZonePosition.setZero()
    RedZoneRadius = 0f
    TotalWarningDuration = 0f
    ElapsedWarningDuration = 0f
    TotalReleaseDuration = 0f
    ElapsedReleaseDuration = 0f
    NumJoinPlayers = 0
    NumAlivePlayers = 0
    NumAliveTeams = 0
    RemainingTime = 0
    MatchElapsedMinutes = 0
    NumTeams = 0
  }
  
  var TotalWarningDuration = 0f
  var ElapsedWarningDuration = 0f
  var RemainingTime = 0
  var MatchElapsedMinutes = 0
  val SafetyZonePosition = Vector2()
  var SafetyZoneRadius = 0f
  val SafetyZoneBeginPosition = Vector2()
  var SafetyZoneBeginRadius = 0f
  val PoisonGasWarningPosition = Vector2()
  var PoisonGasWarningRadius = 0f
  val RedZonePosition = Vector2()
  var RedZoneRadius = 0f
  var TotalReleaseDuration = 0f
  var ElapsedReleaseDuration = 0f
  var NumJoinPlayers = 0
  var NumAlivePlayers = 0
  var NumAliveTeams = 0
  var NumTeams = 0
  
  fun process(actor: Actor, bunch: Bunch, repObj: NetGuidCacheObject?, waitingHandle: Int, data: HashMap<String, Any?>): Boolean {
        with(bunch) {
            when (waitingHandle) {
                16 -> {
                    //  struct FString MatchId;
                    // 0x0410(0x0010) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient)

                    val MatchId = propertyString()
                    val b = MatchId
                    println ("16 $b")

                }
                17 -> {
                    //  struct FString MatchShortGuid;
                    // 0x0420(0x0010) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient)

                    val MatchShortGuid = propertyString()
                    val b = MatchShortGuid

                }
                18 -> {
                    //  bool bIsCustomGame;
                    // 0x0430(0x0001) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                    val bIsCustomGame = propertyBool()
                    val b = bIsCustomGame
                }
                19 -> {
                    //   bool bIsWinnerZombieTeam;
                    // 0x0431(0x0001) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                    val bIsWinnerZombieTeam = propertyBool()
                    val b = bIsWinnerZombieTeam
                    return false
                }
                20 -> {
                    //   unsigned char                                      UnknownData00[0x2]
                    // 0x0432(0x0002) MISSED OFFSET
                }
                21 -> {
                    //  int                                                NumTeams
                    NumTeams = propertyInt()
                }
            // 0x0434(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                26 -> {
                    //   int                                                RemainingTime

                    RemainingTime = propertyInt()
                }
            // 0x0438(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                27 -> {
                    //   int                                                MatchElapsedMinutes

                    MatchElapsedMinutes = propertyInt()
                }
            // 0x043C(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                28 -> {

                    val bTimerPaused = propertyBool()
                    val b = bTimerPaused

                    //   bool                                               bTimerPaused
                }
            // 0x0440(0x0001) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                29 -> {
                    //   bool                                               bShowLastCircleMark

                    val bShowLastCircleMark = propertyBool()
                    val b = bShowLastCircleMark
                }
            // 0x0441(0x0001) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                30 -> {
                    //   bool                                               bCanShowLastCircleMark
                    val bCanShowLastCircleMark = propertyBool()
                    val b = bCanShowLastCircleMark
                }
            // 0x0442(0x0001) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                31 -> {
                    //   unsigned char                                      UnknownData01[0x1]
                }
            // 0x0443(0x0001) MISSED OFFSET
                32 -> {
                    NumJoinPlayers = propertyInt()

                    //   int                                                NumJoinPlayers
                }
            // 0x0444(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                33 -> {
                    //   int                                                NumAlivePlayers

                    NumAlivePlayers = propertyInt()

                }
            // 0x0448(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                34 -> {
                    // int NumAliveZombiePlayers
                    val value34 = propertyFloat()
                    println ("34 $value34")

                }
            // 0x044C(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                35 -> {
                    //   int                                            NumAliveTeams

                    NumAliveTeams = propertyInt()
                    //println ("35 $NumAliveTeams")
                }
            // 0x0450(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                36 -> {
                    //   int                                                NumStartPlayers

                    val value36 = propertyFloat()
                    println ("36 $value36")

                }
            // 0x0454(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                37 -> {
                    //   int                                                NumStartTeams

                    val NumStartTeams = propertyInt()
                    val b = NumStartTeams
                    //println ("37 $b")

                }
            // 0x0458(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                38 -> { // Blue Circle
                    //   struct FVector                                     SafetyZonePosition

                    val pos = propertyVector()
                    SafetyZonePosition.set(pos.x, pos.y)
                    //println ("38 BLUE $SafetyZonePosition")

                }
            // 0x045C(0x000C) (BlueprintVisible, Net, Transient, IsPlainOldData)
                39 -> {
                    //   float                                              SafetyZoneRadius

                    SafetyZoneRadius = propertyFloat()
                    //println ("39 BLUE $SafetyZoneRadius")

                }
            // 0x0468(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                40 -> { // White Circle
                    //   struct FVector                                     PoisonGasWarningPosition
                    val pos = propertyVector()
                    PoisonGasWarningPosition.set(pos.x, pos.y)
                    println ("40 WHITE $PoisonGasWarningPosition")


                }
            // 0x046C(0x000C) (BlueprintVisible, Net, Transient, IsPlainOldData)
                41 -> {
                    //   float                                              PoisonGasWarningRadius
                    PoisonGasWarningRadius = propertyFloat()
                    println ("41 WHITE $PoisonGasWarningRadius")

                }
            // 0x0478(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                42 -> { // Red cirecle
                    //   struct FVector                                     RedZonePosition
                    val pos = propertyVector()
                    RedZonePosition.set(pos.x, pos.y)
                    val b = RedZonePosition
                    //println ("42 $b")

                }
            // 0x047C(0x000C) (BlueprintVisible, Net, Transient, IsPlainOldData)
                43 -> {
                    //   float                                              RedZoneRadius
                    RedZoneRadius = propertyFloat()
                    val b = RedZoneRadius
                    //println ("43 $b")

                }
            // 0x0488(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
//                44 -> {
//                    //   struct FVector2D                                   LastCirclePosition
//
//
//                }
            // 0x048C(0x0008) (BlueprintVisible, Net, Transient, IsPlainOldData)
                44 -> {
                    //   float                                              TotalReleaseDuration
                    TotalReleaseDuration = propertyFloat()
                    println ("44 $TotalReleaseDuration")

                }
            // 0x0494(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                45 -> {

                    ElapsedReleaseDuration = propertyFloat()
                    println ("45 $ElapsedReleaseDuration")
                }
            // 0x0498(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                46 -> { // Blue circle elapsed time
                    //   float                                              TotalWarningDuration


                    TotalWarningDuration = propertyFloat()
                    //println ("46 $TotalWarningDuration")

                }
            // 0x049C(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                47 -> { 
                    //    float                                              ElapsedWarningDuration

                    ElapsedWarningDuration = propertyFloat()
                    println ("47 $ElapsedWarningDuration")

                }
            // 0x04A0(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                48 -> {
                    //    bool                                               bIsGasRelease


                    val bIsGasRelease = propertyBool()


                }
            // 0x04A4(0x0001) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                49 -> {
                    //    bool                                               bIsTeamMatch


                    val bIsTeamMatch = propertyBool()
                    val b = bIsTeamMatch


                }
            // 0x04A5(0x0001) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                50 -> {
                    //   bool
                    //    bIsZombieMode

                    val bIsZombieMode = propertyBool()


                }
            // 0x04A6(0x0001) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                51 -> {
                    //    bool
                    // bUseXboxUnauthorizedDevice

                    // What the fuck is this one

                }
            // 0x04A7(0x0001) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                52 -> {
                    //   float
                    //   ElapsedGasReleaseDuration - RENAMED ??

                    val ElapsedGasReleaseDuration = propertyFloat()
                    println ("52 $ElapsedGasReleaseDuration")


                    // ElapsedWarningDuration = propertyFloat()


                }
            // 0x04A8(0x0004) (BlueprintVisible, BlueprintReadOnly, ZeroConstructor, Transient, IsPlainOldData)
                54 -> {
                    //    struct FVector                                     LerpSafetyZonePosition


                }
            // 0x04AC(0x000C) (BlueprintVisible, BlueprintReadOnly, Transient, IsPlainOldData)
                55 -> {
                    //   float                                              LerpSafetyZoneRadius



                }
            // 0x04B8(0x0004) (BlueprintVisible, BlueprintReadOnly, ZeroConstructor, Transient, IsPlainOldData)
                56 -> {
                    //    struct FVector                                     SafetyZoneBeginPosition


                }
            // 0x04BC(0x000C) (BlueprintVisible, Net, Transient, IsPlainOldData)
                57 -> {
                    //    float                                              SafetyZoneBeginRadius


                }
            // 0x04C8(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                58 -> {
                    //    EMatchStartType                                    MatchStartType


                }
            // 0x04CC(0x0001) (Net, ZeroConstructor, Transient, IsPlainOldData)
                59 -> {
                    //   bool                                               bIsAnyoneKilled


                }
            // 0x04CD(0x0001) (ZeroConstructor, IsPlainOldData)
                60 -> {
                    //   unsigned char                                      UnknownData02[0x42]


                }
            // 0x04CE(0x0042) MISSED OFFSET
                61 -> {
                    //  class ALevelAttribute*
                    // LevelAttribute;
                }
                62 -> {
                    //  0x0510(0x0008) (ZeroConstructor, Transient, IsPlainOldData)
                    //    unsigned char                                      UnknownData03[0x8]


                }
            // 0x0518(0x0008) MISSED OFFSET
                63 -> {
                    //  bool                                               bIsWarMode


                }
            // 0x0520(0x0001) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                64 -> {
                    //    unsigned char                                      UnknownData04[0x3]


                }
            // 0x0521(0x0003) MISSED OFFSET
                65 -> {
                    //      int                                                GoalScore


                }
            // 0x0524(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                66 -> {
                    //      TArray<int>                                        TeamScores


                }
            // 0x0528(0x0010) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient)
                67 -> {
                    //    int64_t                                            NextRespawnTimeTick


                }
            // 0x0538(0x0008) (Edit, Net, ZeroConstructor, Transient, EditConst, IsPlainOldData)
                68 -> {
                    //     int64_t                                            TimeUpTick


                }
            // 0x0540(0x0008) (Edit, Net, ZeroConstructor, Transient, EditConst, IsPlainOldData)
                69 -> {
                    //    bool                                               bIsTeamElimination


                }
            // 0x0548(0x0001) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                70 -> {
                    //     unsigned char                                      UnknownData05[0x7]


                }
            // 0x0549(0x0007) MISSED OFFSET
                71 -> {
                    //    class UTimerTextBlockUpdater*                      RespawnTimerUpdater;
                    //
                    // 0x0550(0x0008) (ZeroConstructor, IsPlainOldData)
                }
                72 -> {
                    //     class UTimerTextBlockUpdater*                      TimeUpTimerUpdater;



                }
            // 0x0558(0x0008) (ZeroConstructor, IsPlainOldData)
                73 -> return false // If someone could explain why this returns false that would be great
                else -> return false
            }
            return true
        }
    }
}