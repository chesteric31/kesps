package be.chesteric31.kesps.api.web

import be.chesteric31.kesps.api.domain.Transfer
import be.chesteric31.kesps.api.service.TransferRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.time.LocalDate

@RunWith(SpringRunner::class)
@SpringBootTest
class TransferResourceTest {

    lateinit var mockMvc: MockMvc

    @Mock
    lateinit var repository: TransferRepository

    @InjectMocks
    lateinit var resource: TransferResource

    @Before
    fun setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(resource).setMessageConverters(MappingJackson2HttpMessageConverter()).build()
    }

    @Test fun findAll() {
        `when`(repository.findAll()).thenReturn(
                listOf(
                        Transfer("", LocalDate.now(), "Eric Binard", "Belge", "Ligny FC", "Belge", "Charleroi", "Belge", "10 M€")))

        mockMvc.perform(MockMvcRequestBuilders.get("/api/transfers"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].playerName").value("Eric Binard"))
    }

}
