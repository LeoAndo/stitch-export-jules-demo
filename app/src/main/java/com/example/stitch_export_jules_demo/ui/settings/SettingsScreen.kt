package com.example.stitch_export_jules_demo.ui.settings

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "設定",
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
                UserProfile(
                    imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuDbVi9cykSlUDShVS-wtAgZnNczbcZJAVI0KQRXbLTnONaofLYmmPaQCIvZLx8fzaZhlaVOdmDZlWlMmQSxR4Bl6wJaOsmzso1RrUggolGGjHbYf_0QPjd_5OBicSowyxUDYewA3EtMYjxy4ogg_vUUvk-Sc3QhEnzLlMrIUe7r5WLw7Z-rtRW3qraYBowe3t0Yq2GBTrhVavftWNhrIjMTBCJLVPG6Ik13sgmSX-DO9FKnG-yJwsY_Sw-rJiyrsuUoChwnCQmuF9MU",
                    name = "Emily Carter",
                    username = "Emily"
                )
            }
            item {
                SettingsSectionTitle("アカウント")
            }
            item {
                SettingsItem(iconRes = R.drawable.ic_user, title = "プロフィールを編集")
            }
            item {
                SettingsItem(iconRes = R.drawable.ic_lock, title = "パスワードを変更")
            }
            item {
                SettingsSectionTitle("アプリ")
            }
            item {
                SettingsItem(iconRes = R.drawable.ic_bell, title = "通知")
            }
            item {
                SettingsItem(iconRes = R.drawable.ic_ruler, title = "単位")
            }
            item {
                SettingsItem(iconRes = R.drawable.ic_info, title = "アプリについて")
            }
        }
    }
}

@Composable
fun UserProfile(imageUrl: String, name: String, username: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "User Avatar",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = name, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Text(text = username, color = Color(0xFF9eb7a8), fontSize = 14.sp)
        }
    }
}

@Composable
fun SettingsSectionTitle(title: String) {
    Text(
        text = title,
        color = Color.White,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun SettingsItem(@DrawableRes iconRes: Int, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(color = Color(0xFF29382f), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title, color = Color.White, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    StitchexportjulesdemoTheme {
        SettingsScreen()
    }
}
