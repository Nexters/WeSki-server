package nexters.weski.ski_resort

import jakarta.persistence.*
import nexters.weski.common.BaseEntity
import nexters.weski.slope.Slope
import nexters.weski.webcam.Webcam
import java.time.LocalDate

@Entity
@Table(name = "ski_resorts")
data class SkiResort(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val resortId: Long = 0,

    val name: String,

    @Enumerated(EnumType.STRING)
    val status: ResortStatus,

    val openingDate: LocalDate? = null,

    val closingDate: LocalDate? = null,

    val openSlopes: Int = 0,

    val totalSlopes: Int = 0,

    val dayOperatingHours: String? = null,
    val nightOperatingHours: String? = null,
    val lateNightOperatingHours: String? = null,
    val dawnOperatingHours: String? = null,
    val midnightOperatingHours: String? = null,
    val snowfallTime: String? = null,
    val xCoordinate: String,
    val yCoordinate: String,
    val detailedAreaCode: String,
    val broadAreaCode: String,

    @OneToMany(mappedBy = "skiResort")
    val slopes: List<Slope> = emptyList(),

    @OneToMany(mappedBy = "skiResort")
    val webcams: List<Webcam> = emptyList()
) : BaseEntity()

enum class ResortStatus {
    운영중, 운영종료, 예정
}
