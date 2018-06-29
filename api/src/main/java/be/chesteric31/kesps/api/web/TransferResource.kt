package be.chesteric31.kesps.api.web

import be.chesteric31.kesps.api.domain.Transfer
import be.chesteric31.kesps.api.service.TransferRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/api/transfers")
class TransferResource(@Autowired val repository: TransferRepository) {

  @GetMapping("/hello")
  @ResponseBody
  fun hello() = ResponseEntity.ok("Hello you!")

  @GetMapping("/")
  fun transfers(): Iterable<Transfer> {
    return repository.findAll()
  }

  @PostMapping("/")
  @ResponseBody
  fun save(@RequestBody transfer: Transfer): ResponseEntity<Transfer> {
    repository.save(transfer)
    val location = ServletUriComponentsBuilder
      .fromCurrentRequest().path("/{id}")
      .buildAndExpand(transfer.id).toUri()
    return ResponseEntity.created(location).build<Transfer>()
  }
}
