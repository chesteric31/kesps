package be.chesteric31.kesps.api.web

import be.chesteric31.kesps.api.domain.Transfer
import be.chesteric31.kesps.api.service.TransferRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/api")
class TransferResource(private val repository: TransferRepository) {

  @GetMapping("/hello")
  @ResponseBody
  fun hello() = ResponseEntity.ok("Hello you!")

  @GetMapping("/transfers")
  fun transfers(): Iterable<Transfer> {
    return repository.findAll()
  }

  @PostMapping("/transfers")
  @ResponseBody
  fun save(@RequestBody transfer: Transfer): ResponseEntity<Transfer> {
    repository.save(transfer)
    val location = ServletUriComponentsBuilder
      .fromCurrentRequest().path("/{id}")
      .buildAndExpand(transfer.id).toUri()
    return ResponseEntity.created(location).build<Transfer>()
  }
}
