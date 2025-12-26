package com.example.stitch_export_jules_demo.ui.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.stitch_export_jules_demo.ui.theme.StitchexportjulesdemoTheme

@Composable
fun OnboardingScreen(onGetStartedClick: () -> Unit) {
    Surface(color = Color(0xFF111714), modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = "https://lh3.googleusercontent.com/aida-public/AB6AXuCJaQSc5VcAEhmOl6nzR_puoxiXJV_cyHQRiXMC6RIn_jmn7Lw3Wqg0KAx70xRvrjFiG4I9GAM15RcSOPio_RAsWgURVuQldfal1lITnQjR5zy7L9gK1wusTmTMsznT8bIZyfJgkuamhzPAi8A80m6r9PspRo1kEVYVBff8EPN98-N4jvpOZLBY8Bb3PffE9_OfmirsHMP1hlm340Yh_XeqtOkvX9MuWaYtKqSXj3gyOIYcipi2celtVt74sjEgsnJPwB-S86emdoLC",
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "アルプスでスキーを愛する人々のためのモバイルアプリ",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "アルプスの美しい雪景色を背景に、アプリの魅力を伝えるキャッチーなコピーを配置。",
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            Button(
                onClick = onGetStartedClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF38e07b))
            ) {
                Text(
                    text = "はじめる",
                    color = Color(0xFF111714),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    StitchexportjulesdemoTheme {
        OnboardingScreen(onGetStartedClick = {})
    }
}
