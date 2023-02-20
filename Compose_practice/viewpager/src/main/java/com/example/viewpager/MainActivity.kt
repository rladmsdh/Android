package com.example.viewpager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.viewpager.ui.theme.ComposePracticeTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                ViewPager()
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPager() {
    //Tab 목록
    val pages = listOf("페이지1","페이지2","페이지3")
    //TabRow Pager 사용하는 객체 현재 몇 페이지에 있는지 저장
    val pagerState = rememberPagerState()
    //CoroutineScope 선언
    val coroutineScope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        modifier = Modifier.padding(top = 20.dp)
    ) {
       pages.forEachIndexed{ index,title ->
           Tab(
               selected = pagerState.currentPage == index,
               onClick = {
                   coroutineScope.launch {
                       pagerState.scrollToPage(index)
                   }
               },
               text = { Text(text = title)},
           )
       }
    }

    HorizontalPager(state = pagerState, count = pages.size){ page ->
        Text(
            text = page.toString(),
            modifier = Modifier.wrapContentSize(),
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        ViewPager()
     }
}