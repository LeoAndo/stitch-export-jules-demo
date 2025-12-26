package com.example.stitch_export_jules_demo.ui.dashboard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.stitch_export_jules_demo.ui.theme.StitchexportjulesdemoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "スキーダッシュボード",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle menu */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF111714))
            )
        },
        containerColor = Color(0xFF111714)
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            item {
                AsyncImage(
                    model = "https://lh3.googleusercontent.com/aida-public/AB6AXuAIrM7GkIdrZF5BnVA3UuOZUkMxOEbfJMHp1SmT9po8jx6KgEqUVCXVwrXMI7pt7EI4eyfM_o509HuxNlVu8rEUgVZIoz0qBKo8bH9k_epeeAIqb9nA0CdFNRGbzEVXBzCsROR7mK6KbVMJ9XaEeeNc1m64QKn-g7Af8z8nvCqGQlCvHehvAe7Ll9_kBn2PY2fL9VSDAgPCko5x4IUUo5bsSOpejELzWl0BV8_P4N-UuyPSBWuwGw7Jin5qtCwFC3oNNKSktOz1SU7B",
                    contentDescription = "Dashboard header image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16 / 9f)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            item {
                SectionTitle("スキーデータ")
            }
            item {
                SkiDataGrid()
            }
            item {
                SectionTitle("スキー履歴")
            }
            item {
                SkiHistoryChart()
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        color = Color.White,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
    )
}

@Composable
fun SkiDataGrid() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SkiDataCard("滑走距離", "15.2km", modifier = Modifier.weight(1f))
        SkiDataCard("滑走時間", "2時間30分", modifier = Modifier.weight(1f))
        SkiDataCard("最高速度", "65km/h", modifier = Modifier.weight(1f))
    }
}

@Composable
fun SkiDataCard(title: String, value: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = Color(0xFF3d5245),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
    ) {
        Text(text = title, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = value, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SkiHistoryChart() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = Color(0xFF3d5245),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
    ) {
        Text("週間滑走距離", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Medium)
        Text("15.2km", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Row {
            Text("今週", color = Color(0xFF9eb7a8), fontSize = 16.sp)
            Spacer(modifier = Modifier.width(4.dp))
            Text("+10%", color = Color(0xFF0bda43), fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
        Spacer(modifier = Modifier.height(16.dp))
        WeeklyChart()
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text("月", color = Color(0xFF9eb7a8), fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text("火", color = Color(0xFF9eb7a8), fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text("水", color = Color(0xFF9eb7a8), fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text("木", color = Color(0xFF9eb7a8), fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text("金", color = Color(0xFF9eb7a8), fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text("土", color = Color(0xFF9eb7a8), fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text("日", color = Color(0xFF9eb7a8), fontSize = 13.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun WeeklyChart() {
    val points = listOf(
        0.7f, 0.3f, 0.5f, 0.2f, 0.8f, 0.1f, 0.6f, 0.4f, 0.9f, 0.0f, 0.5f, 0.2f, 0.7f, 0.3f
    )

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        val path = Path()
        val width = size.width
        val height = size.height
        val stepX = width / (points.size - 1)

        path.moveTo(0f, height * (1 - points[0]))
        for (i in 1 until points.size) {
            path.lineTo(i * stepX, height * (1 - points[i]))
        }

        drawPath(
            path = path,
            color = Color(0xFF9eb7a8),
            style = Stroke(width = 3.dp.toPx())
        )

        val fillPath = Path()
        fillPath.addPath(path)
        fillPath.lineTo(width, height)
        fillPath.lineTo(0f, height)
        fillPath.close()

        drawPath(
            path = fillPath,
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF29382f),
                    Color.Transparent
                )
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    StitchexportjulesdemoTheme {
        DashboardScreen()
    }
}
