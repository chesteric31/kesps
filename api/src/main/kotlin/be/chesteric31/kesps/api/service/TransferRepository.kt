package be.chesteric31.kesps.api.service

import be.chesteric31.kesps.api.domain.Transfer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TransferRepository : CrudRepository<Transfer, String> {

}
