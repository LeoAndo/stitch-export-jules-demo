package com.example.stitch_export_jules_demo.ui.resorts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.stitch_export_jules_demo.R
import com.example.stitch_export_jules_demo.ui.theme.StitchexportjulesdemoTheme


data class SkiResort(
    val name: String,
    val description: String,
    val imageUrl: String
)

data class Country(
    val name: String,
    val resorts: List<SkiResort>
)

val countries = listOf(
    Country(
        name = "イタリア",
        resorts = listOf(
            SkiResort(
                name = "ドロミテ",
                description = "イタリアのスキーリゾートで、ドロミテの心脳部に位置しています。",
                imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuAxjRNWzzP-YF80Pz-fx7PqsqUAcEYWEjezSjBvj2tVMyYQnqJDM28MJBZ0kOYfmNGuxOH0bSItgF4atG4TOZiQcd5bEijCiEBuk5cNYuoYCkkWAlMWxCA64KN3SN5OmLCQ4Rv824n1giulkSuohDe9u-GTJvIWa4zZksvv0m-f0KMo8hHJUW-xiHCfAhTy7qo4CMTpGqrHN6_WQNkR_rO0ucCAM6BNGXLEEs1_-4xPzVz3IMXOEtzXAfajlCeGM47bgYZoS-Ic5pC6"
            ),
            SkiResort(
                name = "コルティナダンペッツォ",
                description = "イタリアのスキーリゾートで、ドロミテの心脳部に位置しています。",
                imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuBzQJe2GxpL0I4XIx2K9jEtkq1ONm8LpV-OSbolQabf8rFnrfkKU5vPV5rIjd-WkMLdkluZ6TD9FI8_shAL00IgsWvii5Sf4hkgj6BF-NrCF5z7J4Ct6S4FkO8MfG4irA9vk4sjTjHetJe4RyC1vTZOX1TIU8ScVjlQbX3ju7Wiv_g0lQLwAjmGFeJgP-wXS2puoUT5adr0F5MgR2Zrjwlv5Ooz3_bTWyX-CoOmsaJ0yGTZEKK0KBPlu9EQuioQkjo5hIEFRgO9Sif5"
            )
        )
    ),
    Country(
        name = "フランス",
        resorts = listOf(
            SkiResort(
                name = "シャモニー",
                description = "フランスのスキーリゾートで、モンブランの基部に位置しています。",
                imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuAPablW8trdyPltSfWvikCc3HIXo1uIoLcNeshVCmhGR6YNpsi0L1ObTUIR14Zhmk6ZK5hPc1JlkLDZ3pGl5x4AlmvxPniUYmDK1AZBxCgv5pOvghUWWSR4XlVIgutgI1WUMuBqApnPyACa_8DyOORgtryRY_hyneu2H6_-Vm24FatdSkXOQ9UJjumhQJvowJtFhAMWbJ_WiCTCIoEQjo_qjy_ZRCIS4YFpaU58LABB9_KdIZLLZEIVg8KimX01JSGlW1zKESrsrDpn"
            ),
            SkiResort(
                name = "アルベルビル",
                description = "フランスのスキーリゾートで、アルプスの心脳部に位置しています。",
                imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuBoH-Nf8h6XqhPjWbPi5U34sjneMkvyTMaOqGN1orqJbsgtpVR7D9y_6FLaiUg24GvQrMX5SK2BpCdEyojxOmUEI9RsIQDpIVrfQ3S88iNlw-024oX_iX6SA43rzhZsxh2IIUlx1C2OwhHbVQW71nsSR3WznwLqZPkgTj6adaJfn0K64NFb7v5UxRZ1XiGUX4KNaL59GBHzVqKDteeVYS9T0bM5rh2TuVOr3C-_3ygh7Ly8jQYUr-mVgshcEO4URYkoda2SCTKKAwL9"
            )
        )
    ),
    Country(
        name = "スイス",
        resorts = listOf(
            SkiResort(
                name = "ゲルマット",
                description = "スイスのスキーリゾートで、スイスアルプスの心脳部に位置しています。",
                imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuCm32VG-q2ZyQgmJpXDvvtal8x21BjD2mMXCoMOXUjglYW0V9XfsVxPx16DqOW6YP4Q2xOPjdVtX06e1vASfqZ21es4Qlr99Mryk-tgvftShGtqTcHQ8zQd4wRd7NlHS6A1Ha26F7gef9Nq_CMTkO5OXsQVYMwFoj-jK1EBGNu37_YAKRML7IlvmkPfse3pOVjy_XrsFJ0AIdbdDtg3UxHIs_LJK3BTmOc27rsB1S-D794vz6VDzzXRnVdmJjqncYnl9431PkRLH149"
            ),
            SkiResort(
                name = "ゲスターディング",
                description = "スイスのスキーリゾートで、スイスアルプスの心脳部に位置しています。",
                imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuD1Buuyu_HknE4Juhty3SMVg5Jy06jCOy7FmZ5-KjnZljY_uxojO9By3amgnBh2Cde1Eg0WElSqpvE81vbRhGFvw4t6KOFKOMaVRPx0nlzigzQ3HJRPCDTQJYCEg_8LqJkMnY-1VkcqhSWBwaPFQ3giutF8O2J5qyxV0uDAnz8C8HCqAjCLXgdtEyy7g8y8oTgI9WRfK2DChSG73Q2QoBgfqiZivkEa93b3ufWWewdODdOOYhAzYQ_Ouaw1g6gWMbv_rZsgQtHbremI"
            )
        )
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResortsScreen() {
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "スキー場",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF111714))
            )
        },
        containerColor = Color(0xFF111714)
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            item {
                SearchBar(
                    query = searchQuery,
                    onQueryChange = { searchQuery = it }
                )
            }
            item {
                CountryFilters()
            }
            countries.forEach { country ->
                item {
                    Text(
                        text = country.name,
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                    )
                }
                items(country.resorts) { resort ->
                    ResortItem(resort = resort)
                }
            }
        }
    }
}

@Composable
fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        placeholder = { Text("スキー場を検索", color = Color(0xFF9eb7a8)) },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF9eb7a8)) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF29382f),
            unfocusedContainerColor = Color(0xFF29382f),
            disabledContainerColor = Color(0xFF29382f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun CountryFilters() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip("イタリア")
        FilterChip("フランス")
        FilterChip("スイス")
    }
}

@Composable
fun FilterChip(text: String) {
    Box(
        modifier = Modifier
            .background(color = Color(0xFF29382f), shape = CircleShape)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = text, color = Color.White, fontSize = 14.sp)
    }
}

@Composable
fun ResortItem(resort: SkiResort) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(2f)) {
            Text("スキー場", color = Color(0xFF9eb7a8), fontSize = 14.sp)
            Spacer(modifier = Modifier.height(2.dp))
            Text(resort.name, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(2.dp))
            Text(resort.description, color = Color(0xFF9eb7a8), fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.width(16.dp))
        AsyncImage(
            model = resort.imageUrl,
            contentDescription = resort.name,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(16 / 9f)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ResortsScreenPreview() {
    StitchexportjulesdemoTheme {
        ResortsScreen()
    }
}
