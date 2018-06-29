package be.chesteric31.kesps.api.service

import be.chesteric31.kesps.api.domain.Transfer
import org.springframework.data.repository.CrudRepository

interface TransferRepository : CrudRepository<Transfer, String> {

}
