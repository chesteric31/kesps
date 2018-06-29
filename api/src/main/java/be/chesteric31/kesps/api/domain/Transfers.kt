package be.chesteric31.kesps.api.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "transfers")
data class Transfer(
  @Id
  val id: String,
  val date: Date,
  val playerName: String,
  val nationality: String,
  val fromTeam: String?,
  val fromNationality: String?,
  val toTeam: String?,
  val toNationality: String?,
  val amount: Number?
)
