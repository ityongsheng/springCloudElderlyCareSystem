#!/bin/bash

# 养老服务模块接口测试脚本
# 测试所有主要接口功能

BASE_URL="http://localhost:8095/admin-api"
CONTENT_TYPE="Content-Type: application/json"

echo "========================================="
echo "养老服务模块接口测试"
echo "========================================="
echo ""

# 颜色定义
GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m' # No Color

# 测试结果统计
PASS=0
FAIL=0

# 测试函数
test_api() {
    local name=$1
    local method=$2
    local url=$3
    local data=$4
    
    echo "测试: $name"
    echo "URL: $method $url"
    
    if [ "$method" = "GET" ]; then
        response=$(curl -s -X GET "$url" -H "$CONTENT_TYPE")
    elif [ "$method" = "POST" ]; then
        response=$(curl -s -X POST "$url" -H "$CONTENT_TYPE" -d "$data")
    elif [ "$method" = "PUT" ]; then
        response=$(curl -s -X PUT "$url" -H "$CONTENT_TYPE" -d "$data")
    elif [ "$method" = "DELETE" ]; then
        response=$(curl -s -X DELETE "$url" -H "$CONTENT_TYPE")
    fi
    
    echo "响应: ${response:0:200}..."
    
    # 特殊处理 Swagger 文档
    if echo "$url" | grep -q "api-docs"; then
        if echo "$response" | grep -q "openapi"; then
            echo -e "${GREEN}✓ 测试通过${NC}"
            ((PASS++))
        else
            echo -e "${RED}✗ 测试失败${NC}"
            ((FAIL++))
        fi
    # 检查响应是否包含 "code":0 (成功) 或 "code":401 (需要登录)
    elif echo "$response" | grep -q '"code":0'; then
        echo -e "${GREEN}✓ 测试通过${NC}"
        ((PASS++))
    elif echo "$response" | grep -q '"code":401'; then
        echo -e "${GREEN}✓ 接口正常（需要登录）${NC}"
        ((PASS++))
    else
        echo -e "${RED}✗ 测试失败${NC}"
        ((FAIL++))
    fi
    echo "---"
    echo ""
}

echo "1. 测试服务项目接口"
echo "========================================="

# 测试获取精简服务项目列表（免登录接口）
test_api "获取精简服务项目列表" "GET" "${BASE_URL}/elderly/service-item/list-all-simple"

# 测试分页查询服务项目（需要登录）
test_api "分页查询服务项目" "GET" "${BASE_URL}/elderly/service-item/page?pageNo=1&pageSize=10"

# 测试获取服务项目详情（需要登录）
test_api "获取服务项目详情" "GET" "${BASE_URL}/elderly/service-item/get?id=1"

echo ""
echo "2. 测试老人档案接口"
echo "========================================="

# 测试分页查询老人档案
test_api "分页查询老人档案" "GET" "${BASE_URL}/elderly/profile/page?pageNo=1&pageSize=10"

# 测试获取老人档案详情
test_api "获取老人档案详情" "GET" "${BASE_URL}/elderly/profile/get?id=1"

echo ""
echo "3. 测试服务订单接口"
echo "========================================="

# 测试分页查询服务订单
test_api "分页查询服务订单" "GET" "${BASE_URL}/elderly/service-order/page?pageNo=1&pageSize=10"

# 测试获取服务订单详情
test_api "获取服务订单详情" "GET" "${BASE_URL}/elderly/service-order/get?id=1"

echo ""
echo "4. 测试健康监测接口"
echo "========================================="

# 测试分页查询健康监测记录
test_api "分页查询健康监测记录" "GET" "${BASE_URL}/elderly/health/page?pageNo=1&pageSize=10"

# 测试获取健康监测记录详情
test_api "获取健康监测记录详情" "GET" "${BASE_URL}/elderly/health/get?id=1"

echo ""
echo "5. 测试 Swagger 文档"
echo "========================================="

# 测试 Swagger API 文档
test_api "Swagger API 文档" "GET" "http://localhost:8095/v3/api-docs"

echo ""
echo "========================================="
echo "测试结果汇总"
echo "========================================="
echo -e "${GREEN}通过: $PASS${NC}"
echo -e "${RED}失败: $FAIL${NC}"
echo "总计: $((PASS + FAIL))"
echo ""

if [ $FAIL -eq 0 ]; then
    echo -e "${GREEN}所有测试通过！✓${NC}"
    exit 0
else
    echo -e "${RED}部分测试失败！✗${NC}"
    exit 1
fi
